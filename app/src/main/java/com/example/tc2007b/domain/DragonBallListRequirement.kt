package com.example.tc2007b.domain

import com.example.tc2007b.data.DragonBallRepository
import com.example.tc2007b.data.network.model.Character

class DragonBallListRequirement {

    private val repository = DragonBallRepository()

    suspend operator fun invoke(): List<Character>? {
            return repository.getAllCharacters()
        }
    }