package com.example.dotify.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import android.widget.Toast
import androidx.core.content.edit
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dotify.DotifyApplication
import com.example.dotify.NavGraphDirections
import com.example.dotify.R
import com.example.dotify.activity.PlayerActivity
import com.example.dotify.databinding.FragmentSettingsBinding
import com.example.dotify.manager.FetchSongNotiManager
import com.example.dotify.manager.SongNotificationManager
import com.example.dotify.model.Song

const val NOTIFICATIONS_ENABLED_PREF_KEY = "notifications_enabled"

class SettingsFragment : Fragment() {


    private val navController by lazy { findNavController() }
    private lateinit var dotifyApp: DotifyApplication
    private val safeArgs: SettingsFragmentArgs by navArgs()
    private val songNotificationManager: SongNotificationManager by lazy { dotifyApp.notificationManager }
    private val fetchSongNotiManager: FetchSongNotiManager by lazy { dotifyApp.fetchNotiManager }
    private val preferences by lazy { dotifyApp.preferences }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        dotifyApp = context.applicationContext as DotifyApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingsBinding.inflate(layoutInflater)

        with(binding) {

            val receivedSong = safeArgs.song
//            val playCount = safeArgs.playCount
            val playcount = dotifyApp.songPlayCount
            val randSong = dotifyApp.randSong

//            DEBUG
//            Toast.makeText(context, "$receivedSong", Toast.LENGTH_SHORT).show() // DEBUG

            btnProfile.setOnClickListener {
                navController.navigate(R.id.profileFragment)
            }

            btnAbout.setOnClickListener {
                navController.navigate(R.id.aboutFragment)
            }

            btnProfileStat.setOnClickListener {

                if(playcount != null) {
                    navController.navigate(NavGraphDirections.actionGlobalStatisticsFragment(receivedSong))
                }
            }


            switchSettingsPull.isChecked = preferences.getBoolean(NOTIFICATIONS_ENABLED_PREF_KEY, false)
            songNotificationManager.isNotificationEnabled = preferences.getBoolean(NOTIFICATIONS_ENABLED_PREF_KEY, false)

            switchSettingsPull.setOnCheckedChangeListener {  _, isChecked ->
                songNotificationManager.isNotificationEnabled = isChecked

                // Saving the value in preferences whether the switch is on or not
                preferences.edit {
                    putBoolean(NOTIFICATIONS_ENABLED_PREF_KEY, isChecked)
                }

                if (isChecked) {
                    fetchSongNotiManager.fetchPostNoti()
                    Toast.makeText(context, "Notifications enabled", Toast.LENGTH_SHORT).show()
                } else {
                    fetchSongNotiManager.stopPeriodicallyRefreshing()
                    Toast.makeText(context, "Notifications are turned off", Toast.LENGTH_SHORT).show()
                }
            }

        }

        return binding.root
    }

    private fun sendSongtoNotiManager(randSong: Song?) {
        if (randSong != null) {
            Log.i("settingFra","randSong")
            songNotificationManager.publishNewSongNoti(randSong)
        }
    }

    private fun notificationInitialStatus(isChecked: Boolean, randSong: Song?) {
        if (!isChecked) {
            fetchSongNotiManager.stopPeriodicallyRefreshing()
        }

    }
}