package com.example.tc2007b.data

import com.example.tc2007b.data.network.DragonBallApiClient
import com.example.tc2007b.data.network.model.Character

class DragonBallRepository() {
    private val apiDragonBall = DragonBallApiClient()

    suspend fun getAllCharacters(): List<Character>? = apiDragonBall.getAllCharacters()
}