package com.example.shopping_list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product
import com.example.shopping_list.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteProductViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
): ViewModel(){
    val favoriteProducts= favoriteRepository.favoriteItems

    fun removeFromFavorites(product: Product){
        favoriteRepository.removeProductFromFavorites(product)
    }
}