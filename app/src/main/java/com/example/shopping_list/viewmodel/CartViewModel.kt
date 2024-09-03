package com.example.shopping_list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product
import com.example.shopping_list.repository.CartRepository
import com.example.shopping_list.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository,
    private val favoriteRepository: FavoriteRepository,
): ViewModel(){
    val cartItems=cartRepository.cartItems

    fun addToFavorites(product: Product){
        favoriteRepository.addProductToFavorites(product)
    }

    fun removeFromFavorites(product: Product){
        favoriteRepository.removeProductFromFavorites(product)
    }

    fun removeFromCart(product: Product){
        cartRepository.removeProductFromCart(product)
    }
}