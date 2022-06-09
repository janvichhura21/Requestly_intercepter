package com.example.requestly_intercepter.network

import com.example.requestly_intercepter.model.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("data.php")
    fun data(): Call<MainModel>
}