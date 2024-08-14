package com.example.shopping_list.ui.composable.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.composable.product.FavoriteProductGrid
import com.example.shopping_list.ui.composable.product.HomeProductGrid

@Composable
fun FavoriteScreen(navController: NavController) {
    val sampleProducts = listOf(
        Product(
            imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            title = "Iphone",
            price = 19.2,
            description = "Some description",
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            title = "Iphone",
            price = 19.2,
            description = "Some description",
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            title = "Iphone",
            price = 19.2,
            description = "Some description",
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            title = "Iphone",
            price = 19.2,
            description = "Some description",
        )

    )

    FavoriteProductGrid(
        products = sampleProducts,
        navController
    )
}