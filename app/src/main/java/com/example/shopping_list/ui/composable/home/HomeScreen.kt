package com.example.shopping_list.ui.composable.home

import androidx.compose.runtime.Composable
import com.example.shopping_list.ui.composable.product.HomeProductGrid

@Composable
fun HomeScreen(onNavigateToProductDetail: ()-> Unit,
               onNavigateToCart: ()-> Unit) {
    HomeProductGrid(
        onNavigateToProductDetail,
        onNavigateToCart,
    )
}

