package com.example.dotify.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
//import com.ericchee.songdataprovider.Song
//import com.ericchee.songdataprovider.SongDataProvider
import com.example.dotify.DotifyApplication
import com.example.dotify.R
import com.example.dotify.adapter.SongListAdapter
import com.example.dotify.databinding.ActivitySongListBinding
import com.example.dotify.model.AllSongs
import com.example.dotify.model.Song
import kotlinx.coroutines.launch
import android.util.Log

private const val SONG_KEY = "SONG_KEY"
private const val SONG_TITLE = "SONG_TITLE"
private const val SONG_ARTIST = "SONG_ARTIST"

class SongListActivity : AppCompatActivity() {
    private var miniPlayerSong = ""
    var selectedSong : Song? = null

    private val myApp: DotifyApplication by lazy { application as DotifyApplication }
    private val dataRepository by lazy { myApp.dataRepository }
    private lateinit var adapter: SongListAdapter

    private lateinit var songs: List<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_list)

        this.title = "All Songs"


        val binding = ActivitySongListBinding.inflate(layoutInflater).apply { setContentView(root)}



        with(binding) {


            songs = listOf()

//            val listOfSong = listOf<Song>()

            adapter = SongListAdapter(songs)

            // the recyclerView's adapter should be PeopleAdapter(people) or val adapter
            rvSongList.adapter = adapter


            if (savedInstanceState?.getParcelable<Song>(SONG_KEY) != null) {
                val minPlayerText = tvSongTitle
                selectedSong = savedInstanceState.getParcelable(SONG_KEY)

                miniPlayerSong = getString(R.string.miniplayer_song_info, selectedSong?.title, selectedSong?.artist)

                minPlayerText.text = miniPlayerSong

                miniplayer.visibility = View.VISIBLE
            }


            loadSongs()

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
                adapter.updateSongList(songs.toMutableList().shuffled())
            }

            swiperefresh.setOnRefreshListener {
                loadSongs()
                swiperefresh.isRefreshing = false
            }

        }

    }

    private fun loadSongs()  {

        lifecycleScope.launch {
            runCatching {
                Toast.makeText(this@SongListActivity, "loading...", Toast.LENGTH_SHORT).show()

                Log.i("sla", "new songs")
                val songList: AllSongs = dataRepository.getSongs()

                val newSongs = songList.songs
                songs = newSongs
                Toast.makeText(this@SongListActivity, "loaded!", Toast.LENGTH_SHORT).show()
                Log.i("sla", "$newSongs")

                adapter.updateSongList(newSongs.toMutableList().shuffled())
            }.onFailure {
                Toast.makeText(this@SongListActivity, "There was an error fetching songs", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // save the count value in the bundle and let the OS handle the rest.
        outState.putParcelable(SONG_KEY, selectedSong)
        super.onSaveInstanceState(outState)
    }
}