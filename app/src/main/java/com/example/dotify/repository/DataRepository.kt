package com.example.dotify.repository

import com.example.dotify.model.AllSongs
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class DataRepository {

    private val songService = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
            // during the fetch, it is going to use Gson to convert to json automatically by Retrofit,
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SongsService::class.java)

    // suspend fn. can only be called by suspend function.
   suspend fun getSongs() = songService.getAllSongs()
}

interface SongsService {
    @GET("echeeUW/codesnippets/master/musiclibrary.json")
    suspend fun getAllSongs(): AllSongs
}