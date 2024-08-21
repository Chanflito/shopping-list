package com.example.shopping_list.ui.composable.favorite

import androidx.compose.runtime.Composable
import com.example.shopping_list.ui.composable.product.FavoriteProductGrid

@Composable
fun FavoriteScreen(onNavigate: ()-> Unit, favoriteViewModel: FavoriteViewModel) {
    FavoriteProductGrid(
        onNavigate,
        favoriteViewModel
    )
}