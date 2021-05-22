package com.example.dotify.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.navigation.fragment.navArgs
import coil.load
import com.example.dotify.DotifyApplication
import com.example.dotify.databinding.FragmentStatisticsBinding

// TODO : also create a reference to the Application and use the playcount stored there
class StatisticsFragment : Fragment() {

    val safeArgs: SettingsFragmentArgs by navArgs()
    private lateinit var dotifyApp: DotifyApplication


    override fun onAttach(context: Context) {
        super.onAttach(context)

        dotifyApp = context.applicationContext as DotifyApplication

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentStatisticsBinding.inflate(inflater)

        with(binding){


            val receivedSong = safeArgs.song
            val playCount = dotifyApp.songPlayCount

            ivAlbumCover.load(receivedSong.largeImageURL)
            tvSongTitle.text = receivedSong.title
            tvSongCount.text = "$playCount plays"
        }

        return binding.root
    }
}