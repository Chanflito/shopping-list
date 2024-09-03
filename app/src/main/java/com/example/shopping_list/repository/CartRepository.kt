package com.example.shopping_list.repository

import com.example.shopping_list.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepository @Inject constructor() {
    private val _cartItems = MutableStateFlow<List<Product>>(emptyList())
    val cartItems: StateFlow<List<Product>> = _cartItems.asStateFlow()


    fun addProductToCart(product: Product){
        if (findProductById(product) ==null){
            _cartItems.value += product
        }
    }
    fun removeProductFromCart(product: Product){
        if (findProductById(product) !=null){
            _cartItems.value -= product
        }
    }

    private fun findProductById(product: Product): Product?{
        return cartItems.value.find { it.id== product.id }
    }
}