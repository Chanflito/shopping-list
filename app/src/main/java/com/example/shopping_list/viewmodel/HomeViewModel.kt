package com.example.shopping_list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping_list.model.Product
import com.example.shopping_list.repository.CartRepository
import com.example.shopping_list.repository.ProductDetailRepository
import com.example.shopping_list.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val cartRepository: CartRepository,
    private val productDetailRepository: ProductDetailRepository,
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    val products = productRepository.products
    val loadingProducts = productRepository.loadingProduct
    val showRetry = productRepository.showRetry

    val filteredProducts: StateFlow<List<Product>> = searchQuery
        .flatMapLatest { query ->
            products.map { productList ->
                if (query.isBlank()) {
                    productList
                } else {
                    productList.filter { it.title.contains(query, ignoreCase = true) }
                }
            }
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun addProductToCart(product: Product) {
        cartRepository.addProductToCart(product)
    }

    fun selectProduct(product: Product) {
        productDetailRepository.selectProduct(product)
    }

    fun retryLoadingProduct() {
        productRepository.retryLoadingProduct()
    }
}