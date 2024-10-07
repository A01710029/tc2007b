package com.example.tc2007b.data.network

class DragonBallApiClient() {

    private val api: DragonBallAPIService = NetworkModuleDI()

    suspend fun getAllCharacters(): List<Character>? {
        var currentPage = 1
        val limit = 10
        val allCharacters = mutableListOf<Character>()
        var totalPages: Int

        return try {
            do {
                val response = api.getCharacters(page = currentPage, limit = limit)
                allCharacters.addAll(response.data)  // Add characters to the list
                totalPages = response.meta.totalPages  // Get total pages from meta
                currentPage++
            } while (currentPage <= totalPages)

            allCharacters  // Return the full list of characters
        } catch (e: Exception) {
            e.printStackTrace()
            null  // Return null in case of an error
        }
    }