package com.example.dotify.worker

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ericchee.songdataprovider.SongDataProvider
import com.example.dotify.DotifyApplication
import com.example.dotify.model.AllSongs
import kotlinx.coroutines.launch

class FetchPostNotiWorker (context: Context, workerParameters: WorkerParameters): CoroutineWorker(context, workerParameters) {

    private val dotifyApp: DotifyApplication = context.applicationContext as DotifyApplication
    private val dataRepository by lazy { dotifyApp.dataRepository }
    private val emailNotificationManager by lazy { dotifyApp.notificationManager }


    override suspend fun doWork(): Result {

        val allSongs = dataRepository.getSongs().songs
        val randSong = allSongs.random()
        dotifyApp.randSong = randSong

        emailNotificationManager.publishNewSongNoti(randSong)

        Log.i("FetchPostNotiWorker", "${randSong.title}")

        return Result.success()
    }

}