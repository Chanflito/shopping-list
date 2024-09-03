package com.example.shopping_list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product
import com.example.shopping_list.repository.CartRepository
import com.example.shopping_list.repository.FavoriteRepository
import com.example.shopping_list.repository.ProductDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val productDetailRepository: ProductDetailRepository,
    private val favoriteRepository: FavoriteRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    val selectedProduct: StateFlow<Product?> = productDetailRepository.selectedProduct

    val favoriteItems: StateFlow<List<Product>> = favoriteRepository.favoriteItems

    fun toggleFavorite(product: Product) {
        if (favoriteRepository.isFavorite(product)) {
            favoriteRepository.removeProductFromFavorites(product)
        } else {
            favoriteRepository.addProductToFavorites(product)
        }
    }

    fun addToCart(product: Product){
        cartRepository.addProductToCart(product)
    }
}