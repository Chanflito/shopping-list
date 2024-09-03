package com.example.shopping_list.repository

import com.example.shopping_list.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteRepository @Inject constructor() {

    private val _favoriteItems = MutableStateFlow<List<Product>>(emptyList())
    val favoriteItems: StateFlow<List<Product>> = _favoriteItems.asStateFlow()


    fun addProductToFavorites(product: Product){
        if (findProductById(product) ==null){
            _favoriteItems.value += product
        }
    }
    fun removeProductFromFavorites(product: Product){
        if (findProductById(product) !=null){
            _favoriteItems.value -= product
        }
    }

    fun isFavorite(product: Product): Boolean {
        return findProductById(product) != null
    }


    private fun findProductById(product: Product): Product?{
        return favoriteItems.value.find { it.id== product.id }
    }
}