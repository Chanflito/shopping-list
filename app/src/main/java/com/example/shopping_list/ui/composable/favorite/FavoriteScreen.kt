package com.example.shopping_list.ui.composable.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_list.R
import com.example.shopping_list.ui.composable.product.FavoriteProductGrid
import com.example.shopping_list.ui.theme.favoriteScreenPadding
import com.example.shopping_list.ui.theme.favoriteScreenTextStyle
import com.example.shopping_list.viewmodel.FavoriteProductViewModel

@Composable
fun FavoriteScreen(onNavigate: ()-> Unit, viewModel: FavoriteProductViewModel= hiltViewModel()) {
    val favoriteProducts by viewModel.favoriteProducts.collectAsState(initial = listOf())
    if (favoriteProducts.isEmpty()){
        Box(modifier = Modifier.fillMaxSize()){
            Text(
                text = stringResource(id = R.string.no_favorite_items),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(favoriteScreenPadding),
                style = TextStyle(
                    fontSize = favoriteScreenTextStyle,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
    else{
        FavoriteProductGrid(
            onNavigate,
            viewModel
        )
    }

}