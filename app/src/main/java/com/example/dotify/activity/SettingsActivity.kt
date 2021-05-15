package com.example.dotify.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.ericchee.songdataprovider.Song
import com.example.dotify.R
import com.example.dotify.databinding.ActivitySettingsBinding


private const val SONG_KEY = "song"
private const val SONG_COUNT = "playCount"

fun startSettingsActivity(context: Context, song: Song, playCount: Int) {
    with(context) {
        val intent = Intent(context, SettingsActivity::class.java)
        // append intent.
        startActivity(intent.apply {
            putExtra(SONG_KEY, song)
            putExtra(SONG_COUNT, playCount)
        })
    }
}

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private val navController by lazy { findNavController(R.id.navHost) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Settings"

        binding = ActivitySettingsBinding.inflate(layoutInflater).apply { setContentView(root) }

        with(binding) {

            // setting the navGraph programmatically instead of using xml
            // send the intent's data to the start fragment.
            navController.setGraph(R.navigation.nav_graph, intent.extras)
        }

        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}