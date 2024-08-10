package com.example.shopping_list.ui.composable.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.composable.cart.product.ProductCard

@Composable
fun HomeScreen() {
        ProductGridPreview()
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
        onBuyClick = {  }
    )
}

@Composable
fun ProductGrid(
    products: List<Product>,
    onBuyClick: (Product) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(190.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onBuyClick = { onBuyClick(product) }
            )
        }
    }
}
@Composable
@Preview
fun ProductGridPreview() {

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
        onBuyClick = { /* Acción de compra */ }
    )
}