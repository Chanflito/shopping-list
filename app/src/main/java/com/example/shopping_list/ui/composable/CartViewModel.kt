package com.example.shopping_list.ui.composable

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateOf<List<Product>>(emptyList())
    val cartItems: State<List<Product>> = _cartItems

    fun addToCart(product: Product) {
        if (findProductById(product) == null){
            _cartItems.value += product
        }

    }
    fun removeFromCart(product: Product) {
        if (findProductById(product) != null){
            _cartItems.value -= product
        }
    }

    private fun findProductById(product: Product): Product?{
        return cartItems.value.find { it.id== product.id }
    }
}