package com.example.shopping_list.ui.composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.shopping_list.model.Product

class ProductViewModel : ViewModel() {
    private var selectedProduct by mutableStateOf<Product?>(null)

    fun selectProduct(product: Product) {
        selectedProduct = product
    }

    fun getProduct(): Product{
        return selectedProduct!!
    }
}