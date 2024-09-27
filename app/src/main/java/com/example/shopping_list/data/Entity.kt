package com.example.shopping_list.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

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

/**
 *This represents the "shopping list" where each item can have multiple products based on the cart
 **/
@Entity(tableName = "orders")
data class Order(
    @PrimaryKey(autoGenerate = true) val orderId: Int = 0,
    val orderDate: Long
)

@Entity(tableName = "order_items")
data class OrderItem(
    @PrimaryKey(autoGenerate = true) val itemId: Int = 0,
    val orderId: Int,
    val productId: Int,
    val quantity: Int,
    val price: Double,
    val title: String,
    val image: String
)