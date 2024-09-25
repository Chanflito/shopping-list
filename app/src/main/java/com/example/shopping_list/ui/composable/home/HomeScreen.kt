package com.example.shopping_list.ui.composable.home

import androidx.compose.runtime.Composable
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.composable.product.HomeProductGrid

@Composable
fun HomeScreen(onNavigate: ()-> Unit, ) {
    HomeProductGrid(
        onNavigate
    )
}

