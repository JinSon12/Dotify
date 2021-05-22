package com.example.dotify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
//import com.ericchee.songdataprovider.Song
import com.example.dotify.SongDiffCallback
import com.example.dotify.databinding.ItemSongBinding
import com.example.dotify.model.Song

class SongListAdapter (private var listOfSongs: List<Song>): RecyclerView.Adapter<SongListAdapter.SongViewHolder>() {

    var onSongClickListener: (song: Song) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemSongBinding.inflate(LayoutInflater.from(parent.context))

        return SongViewHolder(binding)
    }

    override fun getItemCount(): Int = listOfSongs.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = listOfSongs[position]

        with(holder.binding) {
            tvSongName.text = song.title
            tvArtist.text = song.artist
            ivSmallAlbumPic.load(song.smallImageURL)

            root.setOnClickListener{
                onSongClickListener(song)
            }
        }
    }

    fun updateSongList(newListofSongs: List<Song>) {
        val oldSongList = listOfSongs
        this.listOfSongs = newListofSongs

        val diffCallback = SongDiffCallback(oldSongList, listOfSongs)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
    }


    class SongViewHolder (val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root) {

    }

}