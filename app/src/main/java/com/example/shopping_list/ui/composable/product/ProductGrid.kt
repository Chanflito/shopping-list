package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shopping_list.model.Product

@Composable
fun ProductGrid(
    products: List<Product>,
    onBuyClick: (Product) -> Unit,
    navController: NavController
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(190.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onBuyClick = { onBuyClick(product) },
                onClick = {navController.navigate("productDetail")}
            )
        }
    }
}