package com.example.shopping_list.ui.composable.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping_list.ui.composable.product.FavoriteProductGrid

@Composable
fun FavoriteScreen(onNavigate: ()-> Unit, favoriteViewModel: FavoriteViewModel) {
    val favoriteProducts= favoriteViewModel.favoriteItems.value
    if (favoriteProducts.isEmpty()){
        Box(modifier = Modifier.fillMaxSize()){
            Text(
                text = "There are no favorite items",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
    else{
        FavoriteProductGrid(
            onNavigate,
            favoriteViewModel
        )
    }

}