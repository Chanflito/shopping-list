package com.example.shopping_list.repository

import android.content.Context
import com.example.shopping_list.api.RemoteProductService
import com.example.shopping_list.model.Product
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ProductRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val service : RemoteProductService
) {

    private val _loadingProduct = MutableStateFlow(false)
    val loadingProduct = _loadingProduct.asStateFlow()

    private val _products = MutableStateFlow(listOf<Product>())
    val products = _products.asStateFlow()

    private val _showRetry = MutableStateFlow(false)
    val showRetry = _showRetry.asStateFlow()


    init {
        loadProducts()
    }

    fun retryLoadingProduct() {
        loadProducts()

    }
    private fun loadProducts() {
        _loadingProduct.value = true
        service.getProducts(
            context = context,
            onSuccess = {
                _products.value=it
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
}