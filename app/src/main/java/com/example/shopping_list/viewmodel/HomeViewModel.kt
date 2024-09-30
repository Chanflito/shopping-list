package com.example.shopping_list.viewmodel

import android.content.Context

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopping_list.api.RemoteProductService
import com.example.shopping_list.data.CartProduct
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
class HomeViewModel @Inject constructor(
    @ApplicationContext val context: Context,
    private val service: RemoteProductService,
    private val productDetailRepository: ProductDetailRepository,
) : ViewModel() {


    private val _loadingProduct = MutableStateFlow(false)
    val loadingProduct: StateFlow<Boolean> = _loadingProduct.asStateFlow()

    private val _products = MutableStateFlow(listOf<Product>())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    private val _showRetry = MutableStateFlow(false)
    val showRetry: StateFlow<Boolean> = _showRetry.asStateFlow()


    private val database = ShoppingListDatabase.getDatabase(context)
    private val cartDao = database.cartDao()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()


    init {
        loadProducts()
    }


    private fun loadProducts() {
        _loadingProduct.value = true
        service.getProducts(
            context = context,
            onSuccess = {
                _products.value = it
                _showRetry.value = false
            },
            onFail = {
                _showRetry.value = true
            },
            loadingFinished = {
                _loadingProduct.value = false
            }
        )
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun retryLoadingProduct() {
        loadProducts()
    }


    fun addProductToCart(product: Product) {
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


    fun selectProduct(product: Product) {
        productDetailRepository.selectProduct(product)
    }
}