package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_list.ui.composable.favorite.FavoriteButton
import com.example.shopping_list.viewmodel.FavoriteProductViewModel
import com.example.shopping_list.viewmodel.HomeViewModel

@Composable
fun HomeProductGrid(
    onNavigate: ()-> Unit,
    viewModel: HomeViewModel= hiltViewModel()
) {
    val products by viewModel.products.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(190.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onClick = {
                    viewModel.selectProduct(product)
                    onNavigate() },
                cardButton ={ modifier ->
                    CartButton(
                        modifier = modifier,
                        onClick = {
                            viewModel.addProductToCart(product)
                        },
                        iconSize = 24.dp
                    )
                }
            )
        }
    }
}

@Composable
fun FavoriteProductGrid(
    onNavigate: () -> Unit,
    viewModel: FavoriteProductViewModel
) {
    val favoritesProduct by viewModel.favoriteProducts.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(190.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(favoritesProduct) { product ->
            ProductCard(
                product = product,
                onClick = {
                    onNavigate()},
                cardButton ={ modifier ->
                    FavoriteButton(true, modifier, onFavoriteToggle = {viewModel.removeFromFavorites(product)})
                },
            )
        }
    }
}