package com.example.shopping_list.ui.composable.cart
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.shopping_list.ui.composable.CartViewModel


@Composable
fun CartScreen(cartViewModel: CartViewModel) {
    //TODO: Add here scrolling
    LazyColumn {
        items(cartViewModel.cartItems.value) { product ->
            ProductCartCard(
                product = product,
                onAddToFavorites = {},
                onRemove = {cartViewModel.removeFromCart(product)}
            )
        }
    }
}
