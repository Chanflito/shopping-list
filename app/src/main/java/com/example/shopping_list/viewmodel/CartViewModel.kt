package com.example.shopping_list.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.shopping_list.data.CartProduct
import com.example.shopping_list.data.FavoriteProduct
import com.example.shopping_list.data.ShoppingListDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val database = ShoppingListDatabase.getDatabase(context)
    private val cartDao = database.cartDao()
    private val favoriteDao = database.favoriteDao()

    val cartItems = cartDao.getCartProducts().asFlow()

    val favoriteItems = favoriteDao.getFavoriteProducts().asFlow()



    fun toggleFavorite(product: FavoriteProduct) {
        viewModelScope.launch {
            if (isFavorite(product.id)) {
                favoriteDao.removeFromFavorites(product)
            } else {
                favoriteDao.addToFavorites(product)
            }
        }
    }

    fun removeFromCart(product: CartProduct) {
        viewModelScope.launch {
            cartDao.removeFromCart(product)
        }
    }


    private suspend fun isFavorite(productId: Int): Boolean {
        return favoriteDao.isProductFavorite(productId)
    }
}