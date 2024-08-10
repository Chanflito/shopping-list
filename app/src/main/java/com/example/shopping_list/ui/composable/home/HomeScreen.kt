package com.example.shopping_list.ui.composable.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.composable.product.ProductCard
import com.example.shopping_list.ui.composable.product.ProductGrid

@Composable
fun HomeScreen(navController: NavController) {
        ProductGridPreview(navController)
}
@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    val sampleProduct = Product(
        imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        title = "Iphone",
        price = 19.2,
        description = "some description"
    )
    ProductCard(
        product = sampleProduct,
        onBuyClick = {  },
        onClick = {}
    )
}

@Composable
fun ProductGridPreview(navController: NavController) {

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

    ProductGrid(
        products = sampleProducts,
        onBuyClick = { /* Acción de compra */ },
        navController
    )
}