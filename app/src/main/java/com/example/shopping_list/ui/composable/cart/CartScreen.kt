package com.example.shopping_list.ui.composable.cart
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_list.ui.composable.favorite.FavoriteViewModel
import com.example.shopping_list.ui.theme.Blue40
import com.example.shopping_list.viewmodel.CartViewModel


@Composable
fun CartScreen(viewModel: CartViewModel= hiltViewModel(), favoriteViewModel: FavoriteViewModel) {
    val products by viewModel.cartItems.collectAsState()

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
            Column(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    items(products) { product ->
                        val isFavorite= favoriteViewModel.isFavorite(product)
                        ProductCartCard(
                            product = product,
                            onAddToFavorites = {
                                if (isFavorite){
                                    favoriteViewModel.removeFromFavorite(product)
                                }
                                else{
                                    favoriteViewModel.addToFavorite(product)
                                }
                            },
                            onRemove = { viewModel.removeFromCart(product) },
                            isFavorite
                        )
                    }
                }

                Button(
                    onClick = {  },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                        .width(200.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Blue40
                    ),
                    border = BorderStroke(2.dp, Blue40)
                ) {
                    Text(
                        text = "Buy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}