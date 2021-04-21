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

fun navigateToPlayerActivity(context: Context, song: Song) {
    var intent = Intent(context, PlayerActivity::class.java)

    val bundle = Bundle().apply {
        putParcelable(SONG_KEY, song)
    }

    intent.putExtras(bundle)

    context.startActivity(intent)
}

class PlayerActivity : AppCompatActivity() {
    private lateinit var tvPlayCount: TextView
    private lateinit var btnChangeUser: Button
    private lateinit var binding: ActivityMainBinding

    private val randomNum = Random.nextInt(10, 50)
    var curPlayCount = randomNum

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        tvPlayCount = findViewById(R.id.tvPlayCount)

        tvPlayCount.text = "played $randomNum times"


        btnChangeUser = findViewById(R.id.btnChangeUser)

        btnChangeUser.setOnClickListener {
            val btnText = btnChangeUser.text.toString()
            changeUserClicked(btnText)
        }

        val imgBtnNext = findViewById<ImageButton>(R.id.imgBtnNext)

        imgBtnNext.setOnClickListener { nextClicked() }


        with(binding) {
            val song: Song? = intent.getParcelableExtra<Song>(SONG_KEY)

            if (song != null) {
                tvSongTitle.text = getString(R.string.player_song_title, song.title)
                tvArtist.text = getString(R.string.player_song_artist, song.artist)
                ivAlbumCover.setImageResource(song.largeImageID)
            }
        }
    }

    fun nextClicked() {
        Toast.makeText(this, "Skipping to next Track", Toast.LENGTH_SHORT).show()
    }

    fun prvClicked(view: View) {
        Toast.makeText(this, "Skipping to previous Track", Toast.LENGTH_SHORT).show()
    }

    fun playClicked(view: View) {
        curPlayCount++
        tvPlayCount.text = "played $curPlayCount times "
    }

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


}