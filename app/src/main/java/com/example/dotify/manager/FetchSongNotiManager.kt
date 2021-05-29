package com.example.dotify.manager

import android.content.Context
import androidx.work.*
import com.example.dotify.worker.FetchPostNotiWorker
import java.util.concurrent.TimeUnit

private const val SONG_FETCH_TAG = "SONG_FETCH_TAG"
class FetchSongNotiManager(context: Context) {
    private val workManager: WorkManager = WorkManager.getInstance(context)

    fun fetchPostNoti() {
        val request = PeriodicWorkRequestBuilder<FetchPostNotiWorker>(20, TimeUnit.MINUTES)
//        val request = OneTimeWorkRequestBuilder<FetchPostNotiWorker>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .addTag(SONG_FETCH_TAG)
            .build()

        workManager.enqueue(request)
    }

    fun stopPeriodicallyRefreshing() {
        workManager.cancelAllWorkByTag(SONG_FETCH_TAG)
    }

}