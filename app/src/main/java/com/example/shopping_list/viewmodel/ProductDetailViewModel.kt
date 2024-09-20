package com.example.shopping_list.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.shopping_list.data.CartProduct
import com.example.shopping_list.data.FavoriteProduct
import com.example.shopping_list.data.ShoppingListDatabase
import com.example.shopping_list.model.Product
import com.example.shopping_list.repository.ProductDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val productDetailRepository: ProductDetailRepository,
) : ViewModel() {

    val selectedProduct: StateFlow<Product?> = productDetailRepository.selectedProduct
    private val database = ShoppingListDatabase.getDatabase(context)
    private val cartDao = database.cartDao()
    private val favoriteDao = database.favoriteDao()


    val favoriteItems = favoriteDao.getFavoriteProducts().asFlow()


    fun toggleFavorite(product: Product) {
        viewModelScope.launch {
            if (isFavorite(product)) {
                removeProductFromFavorites(product)
            } else {
                addProductToFavorites(product)
            }
        }
    }

    private suspend fun addProductToFavorites(product: Product) {
        favoriteDao.addToFavorites(
            FavoriteProduct(
                id = product.id,
                title = product.title,
                price = product.price,
                image = product.image,
                description = product.description
            )
        )
    }


    private suspend fun removeProductFromFavorites(product: Product) {
        favoriteDao.removeFromFavoritesById(product.id)
    }

    private suspend fun isFavorite(product: Product): Boolean {
        return favoriteDao.isProductFavorite(product.id)
    }


    // Añadir producto al carrito
    fun addToCart(product: Product) {
        viewModelScope.launch {
            cartDao.addToCart(
                CartProduct(
                    id = product.id,
                    quantity = 1,
                    price = product.price,
                    description = product.description,
                    image = product.image,
                    title = product.title
                )
            )
        }
    }
}