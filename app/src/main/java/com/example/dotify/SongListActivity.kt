package com.example.dotify

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



        with(binding) {
            val adapter = SongListAdapter(listofSong)

            // the recyclerView's adapter should be PeopleAdapter(people) or val adapter
            rvSongList.adapter = adapter

            btnRefresh.setOnClickListener {
                adapter.updateSongList(listofSong.toMutableList().shuffled())

            }
        }

    }
}