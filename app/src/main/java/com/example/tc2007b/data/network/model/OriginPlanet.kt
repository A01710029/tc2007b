package com.example.tc2007b.data.network.model

import com.google.gson.annotations.SerializedName

data class OriginPlanet(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("isDestroyed") val isDestroyed: Boolean,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("deletedAt") val deletedAt: Any?
)
