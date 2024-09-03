package com.example.shopping_list.repository


import com.example.shopping_list.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDetailRepository @Inject constructor(){
    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()

    fun selectProduct(product: Product) {
        _selectedProduct.value = product
    }

}