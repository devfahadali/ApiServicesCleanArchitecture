package com.example.data.models

/**
 *@Author: Fahad Ali
 *@Email:  dev.fahadshabbir@gmail.com
 *@Date: 27/04/2024
 */
data class ProductList(
    val responseCode: Long,
    val products: List<Product>,
)

data class Product(
    val id: Long,
    val name: String,
    val price: String,
    val brand: String,
    val category: Category,
)

data class Category(
    val usertype: Usertype,
    val category: String,
)

data class Usertype(
    val usertype: String,
)