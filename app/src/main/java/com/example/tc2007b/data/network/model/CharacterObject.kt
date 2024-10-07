package com.example.tc2007b.data.network.model

import com.google.gson.annotations.SerializedName

data class CharacterObject (
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<com.example.tc2007b.data.network.model.Character>,
)