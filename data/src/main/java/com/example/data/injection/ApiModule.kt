package com.example.data.injection

import com.example.basenetwork.config.configure
import com.example.data.BASE_URL
import com.example.data.api.ProductApi
import com.example.data.repos.ProductRepoImpl
import com.example.domain.repositories.ProductRepository
import org.koin.dsl.module

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
val apiInjection =  module{

    single {
        configure(ProductApi::class.java, BASE_URL)
    }

    single<ProductRepository> {
        ProductRepoImpl(get())
    }

}