package com.example.dotify.manager

import android.content.Context
import androidx.work.*
import com.example.dotify.worker.FetchPostNotiWorker
import java.util.concurrent.TimeUnit

class FetchPostNotiManager(context: Context) {
    private val workManager: WorkManager = WorkManager.getInstance(context)

    fun fetchPostNoti() {
        val request = PeriodicWorkRequestBuilder<FetchPostNotiWorker>(20, TimeUnit.MINUTES)
            .setInitialDelay(5, TimeUnit.SECONDS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            ).build()

        workManager.enqueue(request)
    }

}