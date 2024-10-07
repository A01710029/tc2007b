package com.example.tc2007b.domain

import com.example.tc2007b.data.DragonBallRepository
import com.example.tc2007b.data.network.model.CharacterBase

class OneCharacterRequirement {
    private val repository = DragonBallRepository()

    suspend operator fun invoke(id: Int): CharacterBase? {
        return repository.getOneCharacter(id)
    }
}