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
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shopping_list.R
import com.example.shopping_list.model.Product
import com.example.shopping_list.nav.TopBar

import com.example.shopping_list.ui.composable.favorite.FavoriteButton
import com.example.shopping_list.ui.theme.favoriteProductLazyVerticalGridColumns
import com.example.shopping_list.ui.theme.favoriteProductLazyVerticalGridHorizontalArrangement
import com.example.shopping_list.ui.theme.favoriteProductLazyVerticalGridVerticalArrangement
import com.example.shopping_list.ui.theme.homeProductCardButtonIconSize
import com.example.shopping_list.ui.theme.homeProductGridCircularProgressIndicatorSize
import com.example.shopping_list.ui.theme.homeProductLazyVerticalGridColumns
import com.example.shopping_list.ui.theme.homeProductLazyVerticalGridHorizontalArrangement
import com.example.shopping_list.ui.theme.homeProductLazyVerticalGridVerticalArrangement
import com.example.shopping_list.ui.theme.homeProductShowRetryVerticalArrangementValue
import com.example.shopping_list.viewmodel.FavoriteProductViewModel
import com.example.shopping_list.viewmodel.HomeViewModel



@Composable
fun HomeProductGrid(
    onNavigateToProductDetail: () -> Unit,
    onNavigateToCart: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val products by viewModel.products.collectAsState()
    val loading by viewModel.loadingProduct.collectAsState()
    val showRetry by viewModel.showRetry.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    var isTopBarVisible by remember { mutableStateOf(true) }

    val scrollState = rememberLazyGridState()

    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemScrollOffset }
            .collect { offset ->
                isTopBarVisible =
                    offset == 0
            }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (isTopBarVisible) {
            TopBar(
                searchText = searchQuery,
                onSearchTextChange = {viewModel.onSearchQueryChanged(it)},
                onCartIconClick = {
                    onNavigateToCart()
                }
            )
        }
        when {
            loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(homeProductGridCircularProgressIndicatorSize)
                            .align(Alignment.Center),
                        color = Color.Blue,
                        trackColor = Color.Gray
                    )
                }
            }

            showRetry -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(homeProductShowRetryVerticalArrangementValue,
                        Alignment.CenterVertically),
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
            }

            else -> {
                val filteredProducts = products.filter { product ->
                    product.title.contains(searchQuery, ignoreCase = true)
                }
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(homeProductLazyVerticalGridColumns),
                    horizontalArrangement = Arrangement.spacedBy(homeProductLazyVerticalGridHorizontalArrangement),
                    verticalArrangement = Arrangement.spacedBy(homeProductLazyVerticalGridVerticalArrangement),
                    state = scrollState
                ) {
                    items(filteredProducts) { product ->
                        ProductCard(
                            product = product,
                            onClick = {
                                viewModel.selectProduct(product)
                                onNavigateToProductDetail()
                            },
                            cardButton = { modifier ->
                                CartButton(
                                    modifier = modifier,
                                    onClick = {
                                        viewModel.addProductToCart(product)
                                    },
                                    iconSize = homeProductCardButtonIconSize
                                )
                            }
                        )
                    }
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
        columns = GridCells.Adaptive(favoriteProductLazyVerticalGridColumns),
        horizontalArrangement = Arrangement.spacedBy(favoriteProductLazyVerticalGridHorizontalArrangement),
        verticalArrangement = Arrangement.spacedBy(favoriteProductLazyVerticalGridVerticalArrangement),
    ) {
        items(favoritesProduct) { product ->
            val toProduct=Product(
                id = product.id,
                image = product.image,
                price = product.price,
                title = product.title,
                description = product.description
            )
            ProductCard(
                product =toProduct,
                onClick = {
                    viewModel.selectProduct(toProduct)
                    onNavigate()
                },
                cardButton = { modifier ->
                    FavoriteButton(
                        true,
                        modifier,
                        onFavoriteToggle = { viewModel.removeFromFavorites(product) })
                },
            )
        }
    }
}