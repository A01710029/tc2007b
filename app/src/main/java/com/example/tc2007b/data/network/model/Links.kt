package com.example.tc2007b.data.network.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("first") val first: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("next") val next: String,
    @SerializedName("last") val last: String
)
