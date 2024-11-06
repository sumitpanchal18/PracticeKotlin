package com.example.practicekt.activity.workManager

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.practicekt.R
import timber.log.Timber

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
                when (workInfo?.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        Timber.tag("NewsAPI").d("Work completed successfully")
                    }

                    WorkInfo.State.FAILED -> {
                        Timber.tag("NewsAPI").e("Work failed")
                    }

                    else -> {
                        Timber.tag("NewsAPI").d("Work state: " + workInfo?.state)
                    }
                }
            }
    }
}