package com.example.tc2007b.data.network

import com.example.tc2007b.data.network.model.ApiResponse
import com.example.tc2007b.data.network.model.Character

class DragonBallApiClient() {

    private val api: DragonBallAPIService = NetworkModuleDI()

    suspend fun getAllCharacters(): List<Character>? {
        var currentPage = 1
        val limit = 10
        val allCharacters = mutableListOf<Character>()
        var totalPages: Int

        return try {
            do {
                val response: ApiResponse = api.getCharacters(page = currentPage, limit = limit)
                allCharacters.addAll(response.items)
                totalPages = response.meta.totalPages
                currentPage++
            } while (currentPage <= totalPages)

            allCharacters  // Return the full list of characters
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}