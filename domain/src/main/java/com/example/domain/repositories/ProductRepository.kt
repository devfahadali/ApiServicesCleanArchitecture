package com.example.domain.repositories

import com.example.domain.models.UiProductList

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */

interface ProductRepository {


    suspend fun getProductList():List<UiProductList>

}