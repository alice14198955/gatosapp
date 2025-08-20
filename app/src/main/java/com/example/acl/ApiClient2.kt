package com.example.acl

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient2 {
    private const val BASE_URL = "https://http.cat/101"

    val instance: CatApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatApi::class.java)
    }
}

