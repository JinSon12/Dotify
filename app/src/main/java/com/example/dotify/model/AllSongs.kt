package com.example.dotify.model

data class AllSongs(
    val title: String,
    val numOfSong: Int,
    val songs: List<Song>,
)
