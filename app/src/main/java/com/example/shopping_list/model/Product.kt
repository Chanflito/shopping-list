package com.example.shopping_list.model

data class Product(
    val id: Int,
    val image: String,
    val price: Double,
    val title: String,
    val description: String
)