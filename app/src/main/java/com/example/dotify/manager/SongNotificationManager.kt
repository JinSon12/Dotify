package com.example.dotify.manager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.ericchee.songdataprovider.Song
import com.example.dotify.R
import com.example.dotify.activity.PlayerActivity
import com.example.dotify.activity.navigateToPlayerActivity
import kotlin.random.Random

class SongNotificationManager (  private val context: Context) {
    private val notificationManager = NotificationManagerCompat.from(context)
    private val NEW_RANDOM_SONG_CHANNEL_ID = "NEW_RANDOM_SONG_CHANNEL_ID"

    init {
        // Initialize all channels
        initNotificationChannels()
    }

    fun publishNewSongNoti(randSong: Song) {
        // Define the intent or action you want when user taps on notification
        val intent = Intent(context, PlayerActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra(EMAIL_INFO_KEY, "This string is coming from the notification")

            if(randSong != null) {
                navigateToPlayerActivity(context, randSong)
            }

        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT) // dont forget to add PendingIntent.FLAG_UPDATE_CURRENT to send data over


        // Build information you want the notification to show
        val builder = NotificationCompat.Builder(context, NEW_RANDOM_SONG_CHANNEL_ID)    // channel id from creating the channel
            .setSmallIcon(R.drawable.icon)
            .setContentTitle("New Email from Post Malone")
            .setContentText("You a SUN FLOWWWWWAAAAAAAAA")
            .setContentIntent(pendingIntent)    // sets the action when user clicks on notification
            .setAutoCancel(true)    // This will dismiss the notification tap
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Tell the OS to publish the notification using the info
        with(notificationManager) {
            // notificationId is a unique int for each notification that you must define
            val notificationId = Random.nextInt()
            notify(notificationId, builder.build())
        }
    }


    private fun initNotificationChannels() {
        initNewSongsChannel()
    }

    private fun initNewSongsChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Info about the channel
            val name = context.getString(R.string.new_song)
            val descriptionText = context.getString(R.string.new_song_channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            // Create channel object
            val channel = NotificationChannel(NEW_RANDOM_SONG_CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Tell the Android OS to create a channel
            notificationManager.createNotificationChannel(channel)
        }
    }

}