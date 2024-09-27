package com.example.shopping_list.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import java.util.Date

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderItems(orderItems: List<OrderItem>)

    @Transaction
    suspend fun placeOrder(cartProducts: List<CartProduct>) {
        val date= Date().time
        val orderId = insertOrder(Order(orderDate = date))

        val orderItems = cartProducts.map { cartProduct ->
            OrderItem(
                orderId = orderId,
                productId = cartProduct.id,
                quantity = cartProduct.quantity,
                price = cartProduct.price,
                title = cartProduct.title,
                image = cartProduct.image
            )
        }
        insertOrderItems(orderItems)
    }
}