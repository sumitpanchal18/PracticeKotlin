package com.example.practicekt.activity.workManager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.net.HttpURLConnection
import java.net.URL

class FetchNewsWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    companion object {
        private const val TAG = "NewsAPI"
    }

    override fun doWork(): Result {
        Log.d(TAG, "Starting news fetch...")
        return try {
            val apiKey = "986e3c9945094c81a20e557c57376371"
            val url = URL("https://newsapi.org/v2/top-headlines?country=us&apiKey=$apiKey")

            Log.d(TAG, "Connecting to URL: $url")

            val connection = url.openConnection() as HttpURLConnection
            connection.apply {
                requestMethod = "GET"
                setRequestProperty("User-Agent", "Mozilla/5.0")
                connectTimeout = 5000
                readTimeout = 5000
            }

            when (connection.responseCode) {
                HttpURLConnection.HTTP_OK -> {
                    val response = connection.inputStream.bufferedReader().use {
                        it.readText()
                    }
                    Log.d(TAG, "Raw response: $response")
                    Result.success()
                }

                else -> {
                    val error = connection.errorStream?.bufferedReader()?.readText()
                    Log.e(TAG, "Error response: $error")
                    Result.failure()
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Exception occurred: ${e.message}")
            e.printStackTrace()
            Result.failure()
        }
    }
}