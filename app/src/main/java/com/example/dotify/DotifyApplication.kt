package com.example.dotify

import android.app.Application
import com.ericchee.songdataprovider.Song

class DotifyApplication:  Application() {
     var songPlayCount: Int? = null

    override fun onCreate() {
        super.onCreate()

    }
}
