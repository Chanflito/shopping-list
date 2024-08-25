package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.shopping_list.ui.composable.CartViewModel
import com.example.shopping_list.ui.composable.ProductViewModel
import com.example.shopping_list.ui.composable.favorite.FavoriteButton
import com.example.shopping_list.ui.composable.favorite.FavoriteViewModel

@Composable
fun ProductDetail(productViewModel: ProductViewModel,
                  cartViewModel: CartViewModel,
                  favoriteViewModel: FavoriteViewModel){
    val product= productViewModel.getProduct()
    val isFavorite = favoriteViewModel.isFavorite(product)
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(8.dp)
        .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model= product.imageUrl,
            contentDescription = "Description",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        ProductTitleText(title = product.title, overflow = null, modifier = Modifier.padding(top = 16.dp))
        ProductPriceText(price = product.price , modifier = Modifier.padding(top = 16.dp))
        ProductDescriptionText(
            description = product.description,
            overflow = null, color = Color.DarkGray , modifier = Modifier.padding(top = 16.dp)
        )

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            CartButton(
                onClick = { cartViewModel.addToCart(product) },
                modifier = Modifier
                    .width(96.dp),
                iconSize = 24.dp
            )
            FavoriteButton(
                isFavorite = favoriteViewModel.isFavorite(product) ,
                onFavoriteToggle = {
                    if (isFavorite){
                        favoriteViewModel.removeFromFavorite(product)
                    }
                    else{
                        favoriteViewModel.addToFavorite(product)
                    }
                },
                modifier = Modifier
            )
        }
    }

}