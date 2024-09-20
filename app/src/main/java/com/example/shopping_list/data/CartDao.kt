package com.example.shopping_list.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToCart(cartProduct: CartProduct)

    @Query("SELECT * FROM cart")
    fun getCartProducts(): LiveData<List<CartProduct>>

    @Delete
    suspend fun removeFromCart(cartProduct: CartProduct)

    @Query("DELETE FROM cart")
    suspend fun clearCart()

    @Query("UPDATE cart SET quantity = :quantity WHERE id = :productId")
    suspend fun updateProductQuantity(productId: Int, quantity: Int)
}