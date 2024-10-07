package com.example.tc2007b.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("items") val items: List<CharacterBase>,
    @SerializedName("meta") val meta: Meta,
    @SerializedName("links") val links: Links
)
