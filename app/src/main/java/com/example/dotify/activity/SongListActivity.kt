package com.example.dotify.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ericchee.songdataprovider.Song
import com.ericchee.songdataprovider.SongDataProvider
import com.example.dotify.R
import com.example.dotify.adapter.SongListAdapter
import com.example.dotify.databinding.ActivitySongListBinding

private const val SONG_KEY = "SONG_KEY"
private const val SONG_TITLE = "SONG_TITLE"
private const val SONG_ARTIST = "SONG_ARTIST"

class SongListActivity : AppCompatActivity() {
    private var miniPlayerSong = ""
    var selectedSong : Song? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)

        this.title = "All Songs"

        val listofSong: List<Song> = SongDataProvider.getAllSongs()

        val binding = ActivitySongListBinding.inflate(layoutInflater).apply { setContentView(root)}



        with(binding) {
            val adapter = SongListAdapter(listofSong)

            // the recyclerView's adapter should be PeopleAdapter(people) or val adapter
            rvSongList.adapter = adapter

            if (savedInstanceState?.getParcelable<Song>(SONG_KEY) != null) {
                val minPlayerText = tvSongTitle
                selectedSong = savedInstanceState.getParcelable(SONG_KEY)

                miniPlayerSong = getString(R.string.miniplayer_song_info, selectedSong?.title, selectedSong?.artist)

                minPlayerText.text = miniPlayerSong

                miniplayer.visibility = View.VISIBLE
            }

            // when clicked on a song
            adapter.onSongClickListener = { song: Song ->
                val minPlayerText = tvSongTitle

                selectedSong = song

                miniPlayerSong = getString(R.string.miniplayer_song_info, song.title, song.artist)

                minPlayerText.text = miniPlayerSong

                miniplayer.visibility = View.VISIBLE

            }

            miniplayer.setOnClickListener {

                val selectedSong = selectedSong

                if(selectedSong != null) {
                    navigateToPlayerActivity(this@SongListActivity, selectedSong)
                }
            }

            btnRefresh.setOnClickListener {
                adapter.updateSongList(listofSong.toMutableList().shuffled())

            }


        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        // save the count value in the bundle and let the OS handle the rest.
        outState.putParcelable(SONG_KEY, selectedSong)
        super.onSaveInstanceState(outState)
    }
}