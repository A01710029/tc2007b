package com.example.tc2007b.data

import com.example.tc2007b.data.network.DragonBallApiClient
import com.example.tc2007b.data.network.model.ApiResponse
import com.example.tc2007b.data.network.model.CharacterBase

class DragonBallRepository() {
    private val apiDragonBall = DragonBallApiClient()

    suspend fun getAllCharacters(limit: Int): ApiResponse? = apiDragonBall.getAllCharacters(limit)

    suspend fun getOneCharacter(id: Int): CharacterBase? = apiDragonBall.getOneCharacter(id)
}