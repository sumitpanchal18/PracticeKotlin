package com.example.practicekt.activity.contentProvider

import android.annotation.SuppressLint
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.practicekt.R

class ContentProvider : AppCompatActivity() {
    private lateinit var displayDataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        displayDataTextView = findViewById(R.id.displayDataTextView)
        val queryButton: Button = findViewById(R.id.queryButton)

        queryButton.setOnClickListener {
            queryReceivedData()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun queryReceivedData() {
        try {
            // Log all available content providers
            packageManager.queryContentProviders(null, 0, 0).forEach { providerInfo ->
                Log.d("ReceiverActivity", "Registered Provider: ${providerInfo.authority}")
            }

            // Try multiple possible URIs
            val possibleUris = listOf(
                "content://mvvm.app.dragerhill.provider/data"
            )

            var successfulUri: Uri? = null

            for (uriString in possibleUris) {
                try {
                    val contentUri = Uri.parse(uriString)
                    Log.d("ReceiverActivity", "Attempting to query URI: $uriString")

                    val projection = arrayOf(
                        DatabaseHelper.COLUMN_ID,
                        DatabaseHelper.COLUMN_NAME,
                        DatabaseHelper.COLUMN_VALUE,
                        DatabaseHelper.COLUMN_TIMESTAMP
                    )

                    val cursor: Cursor? = contentResolver.query(
                        contentUri,
                        projection,
                        null,
                        null,
                        "${DatabaseHelper.COLUMN_TIMESTAMP} DESC"
                    )

                    if (cursor != null) {
                        successfulUri = contentUri

                        val resultBuilder = StringBuilder()
                        cursor.use {
                            while (it.moveToNext()) {
                                val id = it.getInt(it.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID))
                                val name = it.getString(it.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME))
                                val value = it.getString(it.getColumnIndexOrThrow(DatabaseHelper.COLUMN_VALUE))
                                val timestamp = it.getString(it.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TIMESTAMP))

                                resultBuilder.append("ID: $id\n")
                                resultBuilder.append("Name: $name\n")
                                resultBuilder.append("Value: $value\n")
                                resultBuilder.append("Timestamp: $timestamp\n\n")
                            }
                        }

                        displayDataTextView.text = resultBuilder.toString()
                        Log.d("ReceiverActivity", "Successfully queried URI: $uriString")
                        return
                    }
                } catch (e: Exception) {
                    Log.e("ReceiverActivity", "Error querying URI $uriString: ${e.message}", e)
                }
            }

            if (successfulUri == null) {
                Log.e("ReceiverActivity", "Could not query any URI")
                displayDataTextView.text = "No successful URI found"
            }
        } catch (e: Exception) {
            Log.e("ReceiverActivity", "Unexpected error: ${e.message}", e)
            displayDataTextView.text = "Error: ${e.message}"
        }
    }
}