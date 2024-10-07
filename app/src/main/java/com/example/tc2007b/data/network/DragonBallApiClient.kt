package com.example.tc2007b.data.network

import android.util.Log
import com.example.tc2007b.data.network.model.ApiResponse
import com.example.tc2007b.data.network.model.CharacterBase

class DragonBallApiClient() {

    private val api: DragonBallAPIService = NetworkModuleDI()

    suspend fun getAllCharacters(limit: Int): ApiResponse? {
        return try {
            api.getCharacters(limit)
        } catch (e: Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getOneCharacter(id: Int): CharacterBase? {
        return try {
            api.getOneCharacter(id)
        } catch (e: Exception) {
            Log.e("DragonBallApiClient", "Error fetching the character: ${e.message}", e)
            e.printStackTrace()
            null
        }
    }
}