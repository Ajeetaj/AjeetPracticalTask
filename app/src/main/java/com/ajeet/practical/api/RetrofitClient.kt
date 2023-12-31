package com.ajeet.practical.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val BASE_URL="https://api.deonde.co/"

    fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}