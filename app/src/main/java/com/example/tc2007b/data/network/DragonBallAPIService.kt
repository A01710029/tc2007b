package com.example.tc2007b.data.network

import com.example.tc2007b.data.network.model.ApiResponse
import com.example.tc2007b.data.network.model.CharacterBase
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DragonBallAPIService {
    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int
    ): ApiResponse

    @GET("characters/{id}")
    suspend fun getOneCharacter(
        @Path("id") id: Int): CharacterBase
}