package com.example.apiservicescleanarchitecture.retofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 25/04/2024
 */

object RetrofitHelper {

    val BASE_URL = "https://automationexercise.com/api/"

    fun getInstance(): Retrofit {

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}