package com.example.dotify

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ericchee.songdataprovider.Song
import com.example.dotify.databinding.ItemSongBinding

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
            ivSmallAlbumPic.setImageResource(song.smallImageID)

            root.setOnClickListener{
                onSongClickListener(song)
            }
        }
    }

    fun updateSongList(newListofSongs: List<Song>) {
        this.listOfSongs = newListofSongs

        notifyDataSetChanged()

    }


    class SongViewHolder (val binding: ItemSongBinding): RecyclerView.ViewHolder(binding.root) {

    }

}