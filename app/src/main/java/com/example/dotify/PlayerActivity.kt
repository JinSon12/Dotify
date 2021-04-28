package com.example.dotify

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.ericchee.songdataprovider.Song
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
    private lateinit var btnChangeUser: Button
    private lateinit var binding: ActivityMainBinding

    private val randomNum = Random.nextInt(0, 50)
    private var curPlayCount = randomNum

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        btnChangeUser = findViewById(R.id.btnSettings)
        btnChangeUser.setOnClickListener {
            val btnText = btnChangeUser.text.toString()
            changeUserClicked(btnText)
        }

        val imgBtnNext = findViewById<ImageButton>(R.id.imgBtnNext)


        with(binding) {
            val song: Song? = intent.getParcelableExtra<Song>(SONG_KEY)

            if (savedInstanceState != null) {
                curPlayCount = savedInstanceState.getInt(COUNT_NUM_KEY, randomNum)
            }

            if (song != null) {
                tvSongTitle.text = getString(R.string.player_song_title, song.title)
                tvArtist.text = getString(R.string.player_song_artist, song.artist)
                ivAlbumCover.setImageResource(song.largeImageID)
            }

            tvPlayCount.text = "played $curPlayCount times"

            // ? nextClicked is this the right way to handle this? What should be the View here?
            imgBtnNext.setOnClickListener { nextClicked(root) }

            imgBtnPlay.setOnClickListener {
                curPlayCount++
                tvPlayCount.text = "played $curPlayCount times "
            }

            btnSettings.setOnClickListener {
                startSettingsActivity(this@PlayerActivity)
            }

        }
    }

    fun nextClicked(view: View) {
        Toast.makeText(this, "Skipping to next Track", Toast.LENGTH_SHORT).show()
    }

    fun prvClicked(view: View) {
        Toast.makeText(this, "Skipping to previous Track", Toast.LENGTH_SHORT).show()
    }

//    fun playClicked(view: View) {
//    }

    fun changeUserClicked(btnText: String) {
        Log.i("jin", btnText)
        val tvUserName = findViewById<TextView>(R.id.tvUserName)
        val etUserName = findViewById<EditText>(R.id.etUserName)

        // prompt input from the user
        if (btnText == "Change User") {
            tvUserName.visibility = View.GONE
            etUserName.visibility = View.VISIBLE
            btnChangeUser.text = "Apply"

        } else if (btnText == "Apply") {
            tvUserName.visibility = View.VISIBLE
            etUserName.visibility = View.GONE
            var input = etUserName.text.toString()
            tvUserName.text = input
            btnChangeUser.text = "Change User"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // save the count value in the bundle and let the OS handle the rest.
        outState.putInt(COUNT_NUM_KEY, curPlayCount)
        super.onSaveInstanceState(outState)
    }


}