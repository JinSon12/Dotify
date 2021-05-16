package com.example.dotify.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.navigation.ui.setupActionBarWithNavController
import com.ericchee.songdataprovider.Song
import com.example.dotify.DotifyApplication
import com.example.dotify.R
import com.example.dotify.adapter.SongListAdapter
import com.example.dotify.databinding.ActivityMainBinding
import kotlin.random.Random

private const val SONG_KEY = "song"
private const val COUNT_NUM_KEY = "COUNT_NUM_KEY"

fun navigateToPlayerActivity(context: Context, song: Song) {
    var intent = Intent(context, PlayerActivity::class.java)

    val bundle = Bundle().apply {
        putParcelable(SONG_KEY, song)
    }

    intent.putExtras(bundle)

    context.startActivity(intent)
}

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SongListAdapter
    private lateinit var dotifyApp: DotifyApplication

    private val randomNum = Random.nextInt(1, 50)
    private var curPlayCount = randomNum
    private var songPlayCount = curPlayCount

    private var song: Song? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        this.song = intent.getParcelableExtra<Song>(SONG_KEY)

        val songObj = this.song

        dotifyApp = this.applicationContext as DotifyApplication


        val imgBtnNext = findViewById<ImageButton>(R.id.imgBtnNext)

        val songPlayCount = dotifyApp.songPlayCount

        with(binding) {


            Log.i("playerActivity", songPlayCount.toString())


            if (songPlayCount != null && savedInstanceState != null) {
//                curPlayCount = savedInstanceState.getInt(COUNT_NUM_KEY, randomNum)
    // instead of using the savedInstanceState, now we will use the Application Data

                curPlayCount = songPlayCount
                Log.i("playerActivity-71", curPlayCount.toString())
                Log.i("playerActivity-71", savedInstanceState.toString())
            }

            if (songObj != null) {
                tvSongTitle.text = getString(R.string.player_song_title, songObj.title)
                tvArtist.text = getString(R.string.player_song_artist, songObj.artist)
                ivAlbumCover.setImageResource(songObj.largeImageID)
            }

            dotifyApp.songPlayCount = curPlayCount
            tvPlayCount.text = "played ${dotifyApp.songPlayCount} times"


            // ? nextClicked is this the right way to handle this? What should be the View here?
            imgBtnNext.setOnClickListener { nextClicked(root) }

            imgBtnPlay.setOnClickListener {
                // ? why does dotifyApp.songPlaycount = curPlayCount++ doesn't work?
                curPlayCount++
                dotifyApp.songPlayCount = curPlayCount
                tvPlayCount.text = "played ${dotifyApp.songPlayCount} times "
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        // hey look we have modified the menu, so I am just letting you know.
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val song: Song? = intent.getParcelableExtra<Song>(SONG_KEY)
        val songObj = this.song

        if (songObj!= null) {
            when(item.itemId) {
                R.id.menu_settings -> startSettingsActivity(this@PlayerActivity, songObj)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        // destroying this activity when the up button is clicked.
        finish()
        return super.onSupportNavigateUp()
    }

    fun nextClicked(view: View) {
        Toast.makeText(this, "Skipping to next Track", Toast.LENGTH_SHORT).show()
    }

    fun prvClicked(view: View) {
        Toast.makeText(this, "Skipping to previous Track", Toast.LENGTH_SHORT).show()
    }

    // for handling orientations and so on (when a new instance of activity is created)
    // and maintaining the data that it has.
//    override fun onSaveInstanceState(outState: Bundle) {
//        // save the count value in the bundle and let the OS handle the rest.
//        outState.putInt(COUNT_NUM_KEY, curPlayCount)
//        super.onSaveInstanceState(outState)
//    }


}