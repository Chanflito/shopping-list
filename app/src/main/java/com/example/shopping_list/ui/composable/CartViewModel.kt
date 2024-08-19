package com.example.shopping_list.ui.composable

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateOf<List<Product>>(emptyList())
    val cartItems: State<List<Product>> = _cartItems

    //TODO: Add here when product already exists verification
    fun addToCart(product: Product) {
        _cartItems.value += product
    }
    fun removeFromCart(product: Product) {
        _cartItems.value -= product
    }
}