package com.example.acl
import com.example.acl.CatResponse
import retrofit2.Call
import retrofit2.http.GET


interface CatApi {
    @GET("/status")
    fun getStatusCat(): Call<CatResponse>
}