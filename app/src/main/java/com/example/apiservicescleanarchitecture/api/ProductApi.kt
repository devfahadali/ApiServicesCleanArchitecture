package com.example.apiservicescleanarchitecture.api

import com.example.apiservicescleanarchitecture.models.ProductList
import retrofit2.Response
import retrofit2.http.GET

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 25/04/2024
 */
interface ProductApi {


    @GET("productsList")
    suspend fun getProductList(): Response<ProductList>

}