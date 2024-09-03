package com.example.shopping_list.ui.composable.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product

class FavoriteViewModel: ViewModel() {
        private val _favoriteItems = mutableStateOf<List<Product>>(emptyList())
        val favoriteItems: State<List<Product>> = _favoriteItems

        fun addToFavorite(product: Product) {
            if (findProductById(product) == null){
                _favoriteItems.value += product
            }

        }
        fun removeFromFavorite(product: Product) {
            if (findProductById(product) != null){
                _favoriteItems.value -= product
            }
        }

        fun isFavorite(product: Product): Boolean{
            return favoriteItems.value.find { it.id== product.id } != null
        }

        private fun findProductById(product: Product): Product?{
            return favoriteItems.value.find { it.id== product.id }
        }


}
