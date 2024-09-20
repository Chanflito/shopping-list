package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_list.R
import com.example.shopping_list.data.CartProduct
import com.example.shopping_list.model.Product
import com.example.shopping_list.nav.TopBar
import com.example.shopping_list.ui.composable.favorite.FavoriteButton
import com.example.shopping_list.viewmodel.FavoriteProductViewModel
import com.example.shopping_list.viewmodel.HomeViewModel

@Composable
fun HomeProductGrid(
    onNavigate: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val products by viewModel.filteredProducts.collectAsState()
    val loading by viewModel.loadingProduct.collectAsState()
    val showRetry by viewModel.showRetry.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TopBar(
            searchText = searchQuery,
            onSearchTextChange = { query ->
                viewModel.onSearchQueryChanged(query)
            },
            onCartIconClick = {

            }
        )
        if (loading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.Center),
                    color = Color.Blue,
                    trackColor = Color.Gray
                )
            }
        } else if (showRetry) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.retry),
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(id = R.string.retry_load_products))
                Button(onClick = { viewModel.retryLoadingProduct() }) {
                    Text(text = stringResource(id = R.string.retry))
                }
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(190.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(products) { product ->
                    ProductCard(
                        product = product,
                        onClick = {
                            viewModel.selectProduct(product)
                            onNavigate()
                        },
                        cardButton = { modifier ->
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
    }
}

@Composable
fun FavoriteProductGrid(
    onNavigate: () -> Unit,
    viewModel: FavoriteProductViewModel
) {
    val favoritesProduct by viewModel.favoriteProducts.collectAsState(initial = listOf())
    LazyVerticalGrid(
        columns = GridCells.Adaptive(190.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(favoritesProduct) { product ->
            ProductCard(
                product = Product(
                    id= product.id,
                    image = product.image,
                    price = product.price,
                    title = product.title,
                    description = product.description
                ),
                onClick = {
                    onNavigate()},
                cardButton ={ modifier ->
                    FavoriteButton(true, modifier, onFavoriteToggle = {viewModel.removeFromFavorites(product)})
                },
            )
        }
    }
}