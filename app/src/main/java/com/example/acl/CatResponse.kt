package com.example.acl

import com.google.gson.annotations.SerializedName

data class CatResponse(
    @SerializedName("url") val url: String,
    val message: String
)
