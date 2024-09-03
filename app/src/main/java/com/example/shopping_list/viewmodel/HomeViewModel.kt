package com.example.shopping_list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product
import com.example.shopping_list.repository.CartRepository
import com.example.shopping_list.repository.ProductDetailRepository
import com.example.shopping_list.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val cartRepository: CartRepository,
    private val productDetailRepository: ProductDetailRepository
): ViewModel(){

    val products= productRepository.products

    fun addProductToCart(product: Product){
        cartRepository.addProductToCart(product)
    }

    fun selectProduct(product:Product){
        productDetailRepository.selectProduct(product)
    }
}