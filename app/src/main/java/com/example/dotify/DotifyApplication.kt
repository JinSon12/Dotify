package com.example.dotify

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.dotify.manager.FetchSongNotiManager
import com.example.dotify.manager.SongNotificationManager
import com.example.dotify.model.Song
import com.example.dotify.repository.DataRepository

const val DOTIFY_PREPS_KEY = "Dotify_Preps"

class DotifyApplication:  Application() {
    var songPlayCount: Int? = null
    var randSong: Song? = null

    lateinit var dataRepository: DataRepository
    lateinit var notificationManager: SongNotificationManager
    lateinit var fetchNotiManager: FetchSongNotiManager
    lateinit var preferences: SharedPreferences



    override fun onCreate() {
        super.onCreate()
        dataRepository = DataRepository()
        this.notificationManager = SongNotificationManager(this)
        this.fetchNotiManager = FetchSongNotiManager(this)
        this.preferences =  getSharedPreferences(DOTIFY_PREPS_KEY, Context.MODE_PRIVATE)
    }
}
