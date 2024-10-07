package com.example.tc2007b.data.network

import com.example.tc2007b.data.network.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DragonBallAPIService {
    //https://dragonball-api.com/api/characters?page=2&limit=5
    @GET("characters")
    suspend fun getCharacters(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): ApiResponse
}