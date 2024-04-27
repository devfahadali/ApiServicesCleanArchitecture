package com.example.data.api

import com.example.data.Product_List
import com.example.data.models.ProductList
import retrofit2.Response
import retrofit2.http.GET

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
interface ProductApi {

    @GET(Product_List)
    suspend fun getProductList(): Response<ProductList>
}