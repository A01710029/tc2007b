package com.example.tc2007b.domain

import com.example.tc2007b.data.DragonBallRepository
import com.example.tc2007b.data.network.model.ApiResponse
import com.example.tc2007b.data.network.model.CharacterBase

class DragonBallListRequirement {

    private val repository = DragonBallRepository()

    suspend operator fun invoke(limit: Int): ApiResponse? {
            return repository.getAllCharacters(limit)
        }
    }