package com.example.dotify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.navigation.fragment.navArgs
import com.example.dotify.databinding.FragmentStatisticsBinding

class StatisticsFragment : Fragment() {

    val safeArgs: SettingsFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentStatisticsBinding.inflate(inflater)

        with(binding){


            val receivedSong = safeArgs.song
            val playCount = safeArgs.playCount

            ivAlbumCover.setImageResource(receivedSong.largeImageID)
            tvSongTitle.text = receivedSong.title
            tvSongCount.text = "$playCount plays"
        }

        return binding.root
    }
}