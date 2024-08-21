package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shopping_list.model.Product
import com.example.shopping_list.nav.NavItem
import com.example.shopping_list.ui.composable.CartViewModel
import com.example.shopping_list.ui.composable.ProductViewModel
import com.example.shopping_list.ui.composable.favorite.FavoriteButton

@Composable
fun HomeProductGrid(
    products: List<Product>,
    onNavigate: ()-> Unit,
    productViewModel: ProductViewModel,
    cartViewModel: CartViewModel
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(190.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onClick = {
                    productViewModel.selectProduct(product)
                    onNavigate()},
                cardButton ={ modifier ->
                    CartButton(
                        modifier = modifier,
                        onClick = {
                            cartViewModel.addToCart(product)
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
    products: List<Product>,
    onNavigate: () -> Unit,
    productViewModel: ProductViewModel
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(190.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onClick = {
                    productViewModel.selectProduct(product)
                    onNavigate()},
                cardButton ={ modifier ->
                    FavoriteButton(false, modifier) {
                    }
                }
            )
        }
    }
}