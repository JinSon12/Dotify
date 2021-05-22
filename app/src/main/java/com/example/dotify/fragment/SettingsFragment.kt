package com.example.dotify.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dotify.DotifyApplication
import com.example.dotify.NavGraphDirections
import com.example.dotify.R
import com.example.dotify.activity.PlayerActivity
import com.example.dotify.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private val navController by lazy { findNavController() }
    private lateinit var dotifyApp: DotifyApplication
    private val safeArgs: SettingsFragmentArgs by navArgs()

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
        }

        return binding.root
    }
}