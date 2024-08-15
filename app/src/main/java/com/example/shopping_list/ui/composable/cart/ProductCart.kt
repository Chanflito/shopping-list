package com.example.shopping_list.ui.composable.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.shopping_list.ui.composable.favorite.FavoriteButton


@Composable
fun ProductCartCard(
    productName: String,
    productPrice: String,
    operatingSystem: String,
    ram: String,
    screenSize: String,
    sim: String,
    color: String,
    weight: String,
    onAddToFavorites: () -> Unit,
    onRemove: () -> Unit
) {
    var isFavorite by remember { mutableStateOf(false)}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model= "https://fakestoreapi.com/img/61U7T1koQqL._AC_SX679_.jpg",
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(end = 16.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = productName,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = productPrice,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(text = "Operating System: $operatingSystem")
                Text(text = "RAM: $ram")
                Text(text = "Screen size: $screenSize")
                Text(text = "SIM: $sim")
                Text(text = "Color: $color")
                Text(text = "Weight: $weight")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Counter()
                FavoriteButton(
                    isFavorite = isFavorite,
                    onFavoriteToggle = { isFavorite = !isFavorite }
                )
                    IconButton(onClick = onAddToFavorites) {
                        Icon(Icons.Default.Delete, contentDescription = "Remove")
                    }
            }
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableIntStateOf(1) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        IconButton(onClick = { if (count > 1) count-- }, modifier = Modifier.width(24.dp)) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Decrease")
        }
        Text(text = "$count")
        IconButton(onClick = { count++ }, Modifier.width(24.dp)) {
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Increase",)
        }
    }
}
@Preview(showBackground = true,)
@Composable
fun PreviewProductCartCard() {
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