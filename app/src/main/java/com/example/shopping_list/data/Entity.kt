package com.example.shopping_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartProduct(
    @PrimaryKey val id: Int,
    val quantity: Int,
    val image: String,
    val price: Double,
    val title: String,
    val description: String
)

@Entity(tableName = "favorites")
data class FavoriteProduct(
    @PrimaryKey val id: Int,
    val image: String,
    val price: Double,
    val title: String,
    val description: String
)