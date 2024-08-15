package com.example.shopping_list.ui.composable.cart
import androidx.compose.runtime.Composable


@Composable
fun CartScreen() {
    ProductCartCard(
        productName = "Apple iPhone 12 Pro, 128GB, Graphite - Unlocked (Renewed Premium)",
        productPrice = "AR$ 619.150",
        operatingSystem = "iOS 16",
        ram = "4 GB",
        screenSize = "6.1",
        sim = "Dual SIM",
        color = "Graphite",
        weight = "0.362 kg",
        onAddToFavorites = {},
        onRemove = {}
    )
}


