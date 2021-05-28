package com.example.dotify.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ericchee.songdataprovider.SongDataProvider

class FetchPostNotiWorker (context: Context, workerParameters: WorkerParameters): CoroutineWorker(context, workerParameters) {
    override suspend fun doWork(): Result {

        // get a random song
        SongDataProvider.getAllSongs().random()

        Log.i("FetchPostNotiWorker", "fetching now")

        return Result.success()
    }
}