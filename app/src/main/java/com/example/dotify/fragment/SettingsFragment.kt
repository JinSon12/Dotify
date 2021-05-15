package com.example.dotify.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dotify.NavGraphDirections
import com.example.dotify.R
import com.example.dotify.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private val navController by lazy { findNavController() }

    private val safeArgs: SettingsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSettingsBinding.inflate(layoutInflater)

        with(binding) {

            val receivedSong = safeArgs.song
            val playCount = safeArgs.playCount

//            Toast.makeText(context, "$receivedSong", Toast.LENGTH_SHORT).show() // DEBUG

            btnProfile.setOnClickListener {
                navController.navigate(R.id.profileFragment)
            }

            btnAbout.setOnClickListener {
                navController.navigate(R.id.aboutFragment)
            }

            btnProfileStat.setOnClickListener {

                navController.navigate(NavGraphDirections.actionGlobalStatisticsFragment(receivedSong, playCount))

            }

        }

        return binding.root
    }
}