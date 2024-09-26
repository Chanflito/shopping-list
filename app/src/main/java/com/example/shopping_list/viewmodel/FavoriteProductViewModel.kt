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

    fun removeFromFavorites(product: FavoriteProduct) {
        viewModelScope.launch {
            favoriteDao.removeFromFavorites(product)
        }
    }
}