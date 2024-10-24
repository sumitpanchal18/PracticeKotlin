package com.example.practicekt.activity.workManager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.practicekt.R

class WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        val testWork = OneTimeWorkRequestBuilder<FetchNewsWorker>()
            .build()

        WorkManager.getInstance(this)
            .enqueue(testWork)

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(testWork.id)
            .observe(this) { workInfo ->
                when (workInfo.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        Log.d("NewsAPI", "Work completed successfully")
                    }
                    WorkInfo.State.FAILED -> {
                        Log.e("NewsAPI", "Work failed")
                    }
                    else -> {
                        Log.d("NewsAPI", "Work state: ${workInfo.state}")
                    }
                }
            }
    }
}