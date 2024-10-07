package com.example.tc2007b.data.network.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data") val data: List<Character>,
    @SerializedName("meta") val meta: Meta
)
