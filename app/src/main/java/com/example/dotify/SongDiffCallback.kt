package com.example.dotify

import androidx.recyclerview.widget.DiffUtil
import com.ericchee.songdataprovider.Song

class SongDiffCallback (private  val newSongList: List<Song>, private val oldSongList: List<Song>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldSongList.size

    override fun getNewListSize(): Int = newSongList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newSong = newSongList[newItemPosition]
        val oldSong = oldSongList[oldItemPosition]

        return newSong.id == oldSong.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val newSong = newSongList[newItemPosition]
        val oldSong = oldSongList[oldItemPosition]
        return newSong.artist == oldSong.artist && newSong.title == oldSong.title
    }
}
