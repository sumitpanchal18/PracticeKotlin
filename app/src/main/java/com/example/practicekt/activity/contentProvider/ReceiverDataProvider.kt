package com.example.practicekt.activity.contentProvider

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.util.Log

class ReceiverDataProvider : ContentProvider() {
    companion object {
        private const val AUTHORITY = "mvvm.app.dragerhill.provider"
        private const val PATH_DATA = "data"
        
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/$PATH_DATA")
        
        private const val DATA = 1
        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, PATH_DATA, DATA)
        }
    }

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(): Boolean {
        databaseHelper = DatabaseHelper(context!!)
        Log.d("ReceiverDataProvider", "Provider created")
        return true
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        Log.d("ReceiverDataProvider", "Insert called with URI: $uri")
        
        return try {
            val db = databaseHelper.writableDatabase
            
            when (uriMatcher.match(uri)) {
                DATA -> {
                    // Log incoming values
                    values?.keySet()?.forEach { key ->
                        Log.d("ReceiverDataProvider", "Received $key: ${values.get(key)}")
                    }
                    
                    val id = db.insert(DatabaseHelper.TABLE_NAME, null, values)
                    if (id > 0) {
                        val insertedUri = ContentUris.withAppendedId(CONTENT_URI, id)
                        context?.contentResolver?.notifyChange(insertedUri, null)
                        Log.d("ReceiverDataProvider", "Data inserted successfully: $insertedUri")
                        insertedUri
                    } else {
                        Log.e("ReceiverDataProvider", "Failed to insert data")
                        null
                    }
                }
                else -> {
                    Log.e("ReceiverDataProvider", "Unknown URI: $uri")
                    throw IllegalArgumentException("Unknown URI: $uri")
                }
            }
        } catch (e: Exception) {
            Log.e("ReceiverDataProvider", "Error in insert: ${e.message}", e)
            null
        }
    }

    override fun query(
        uri: Uri, 
        projection: Array<out String>?, 
        selection: String?, 
        selectionArgs: Array<out String>?, 
        sortOrder: String?
    ): Cursor {
        val db = databaseHelper.readableDatabase
        return db.query(
            DatabaseHelper.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            sortOrder
        )
    }

    override fun update(
        uri: Uri, 
        values: ContentValues?, 
        selection: String?, 
        selectionArgs: Array<out String>?
    ): Int {
        val db = databaseHelper.writableDatabase
        return db.update(
            DatabaseHelper.TABLE_NAME,
            values,
            selection,
            selectionArgs
        )
    }

    override fun delete(
        uri: Uri, 
        selection: String?, 
        selectionArgs: Array<out String>?
    ): Int {
        val db = databaseHelper.writableDatabase
        return db.delete(
            DatabaseHelper.TABLE_NAME,
            selection,
            selectionArgs
        )
    }

    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            DATA -> "vnd.android.cursor.item/vnd.$AUTHORITY.data"
            else -> null
        }
    }
}