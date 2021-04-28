package com.example.dotify

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.dotify.databinding.ActivitySettingsBinding

fun startSettingsActivity (context: Context) {
    with(context) {
        val intent = Intent(context, SettingsActivity::class.java)
        startActivity(intent)
    }

}

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "Settings"

        binding = ActivitySettingsBinding.inflate(layoutInflater).apply { setContentView(root)}

        with(binding) {
            Log.i("AASD", "I am still alive!!! ")
        }

    }
}