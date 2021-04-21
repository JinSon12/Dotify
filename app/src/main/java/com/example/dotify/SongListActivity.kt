package com.example.dotify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ericchee.songdataprovider.Song
import com.ericchee.songdataprovider.SongDataProvider
import com.example.dotify.databinding.ActivitySongListBinding

class SongListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)

        this.setTitle("All Songs")

        val listofSong: List<Song> = SongDataProvider.getAllSongs()

        val binding = ActivitySongListBinding.inflate(layoutInflater).apply { setContentView(root)}

        var selectedSong : Song? = null




        with(binding) {
            val adapter = SongListAdapter(listofSong)

            // the recyclerView's adapter should be PeopleAdapter(people) or val adapter
            rvSongList.adapter = adapter

            adapter.onSongClickListener = { song: Song ->
                val minPlayerText = tvSongTitle

                selectedSong = song

                minPlayerText.text = getString(R.string.miniplayer_song_info, song.title, song.artist)

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
}