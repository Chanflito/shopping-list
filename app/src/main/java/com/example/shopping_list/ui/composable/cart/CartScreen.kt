package com.example.shopping_list.ui.composable.cart
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping_list.ui.composable.CartViewModel


@Composable
fun CartScreen(cartViewModel: CartViewModel) {
    val products= cartViewModel.cartItems.value
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (products.isEmpty()) {
            Text(
                text = "There are no items in the cart",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
        else {
            LazyColumn (modifier = Modifier.fillMaxSize()) {
                items(products) { product ->
                    ProductCartCard(
                        product = product,
                        onAddToFavorites = {},
                        onRemove = { cartViewModel.removeFromCart(product) }
                    )
                }
            }
        }
    }
}