package com.example.shopping_list.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.shopping_list.data.FavoriteProduct
import com.example.shopping_list.data.ShoppingListDatabase
import com.example.shopping_list.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteProductViewModel @Inject constructor(
    @ApplicationContext private val context: Context
): ViewModel() {

    private val database = ShoppingListDatabase.getDatabase(context)
    private val favoriteDao = database.favoriteDao()

    val favoriteProducts= favoriteDao.getFavoriteProducts().asFlow()


    fun addToFavorites(product: FavoriteProduct) {
        viewModelScope.launch {
            favoriteDao.addToFavorites(product)
        }
    }


    fun removeFromFavorites(product: FavoriteProduct) {
        viewModelScope.launch {
            favoriteDao.removeFromFavorites(product)
        }
    }

    fun removeFromFavoritesById(productId: Int) {
        viewModelScope.launch {
            favoriteDao.removeFromFavoritesById(productId)
        }
    }

    suspend fun isFavorite(productId: Int): Boolean {
        return favoriteDao.isProductFavorite(productId)
    }
}