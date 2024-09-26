package com.example.shopping_list.ui.composable.cart
import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_list.R
import com.example.shopping_list.data.FavoriteProduct
import com.example.shopping_list.ui.theme.Blue40
import com.example.shopping_list.viewmodel.CartViewModel


@Composable
fun CartScreen(viewModel: CartViewModel= hiltViewModel()) {
    val products by  viewModel.cartItems.collectAsState(initial = listOf())
    val favoriteItems by viewModel.favoriteItems.collectAsState(initial = listOf())
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (products.isEmpty()) {
            Text(
                text = stringResource(id = R.string.empty_cart),
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
                        val isFavorite = remember { mutableStateOf(false) }
                        LaunchedEffect(favoriteItems, product) {
                            isFavorite.value = true && favoriteItems.any { it.id == product.id }
                        }
                        ProductCartCard(
                            product = product,
                            onAddToFavorites = {
                                viewModel.toggleFavorite(FavoriteProduct(
                                    id= product.id,
                                    image = product.image,
                                    price= product.price,
                                    title = product.title,
                                    description = product.description
                                ))
                                if (isFavorite.value){
                                    Toast.makeText(context, R.string.removed_from_favorites, Toast.LENGTH_SHORT).show()
                                }
                                else{
                                    Toast.makeText(context, R.string.added_to_favorites, Toast.LENGTH_SHORT).show()
                                }
                            },
                            onRemove = { viewModel.removeFromCart(product) },
                            isFavorite.value,
                            onQuantityChange = { quantity -> viewModel.updateQuantity(product.id, quantity)}
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
                        text = stringResource(id = R.string.add_to_product_bag),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}