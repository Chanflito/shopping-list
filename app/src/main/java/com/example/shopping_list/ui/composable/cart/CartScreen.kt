package com.example.shopping_list.ui.composable.cart


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


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


