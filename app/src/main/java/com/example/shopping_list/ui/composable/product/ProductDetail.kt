package com.example.shopping_list.ui.composable.product

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.shopping_list.R
import com.example.shopping_list.ui.composable.favorite.FavoriteButton
import com.example.shopping_list.ui.theme.productDetailCartButtonIconSize
import com.example.shopping_list.ui.theme.productDetailCartButtonWith
import com.example.shopping_list.ui.theme.productDetailColumnPadding
import com.example.shopping_list.ui.theme.productDetailProductDescriptionTextPaddingTop
import com.example.shopping_list.ui.theme.productDetailProductPriceTextPaddingTop
import com.example.shopping_list.ui.theme.productDetailProductTitleTextPaddingTop
import com.example.shopping_list.ui.theme.productDetailRowHorizontalArrangement
import com.example.shopping_list.ui.theme.productDetailRowPaddingTop
import com.example.shopping_list.viewmodel.ProductDetailViewModel

@Composable
fun ProductDetail(viewModel: ProductDetailViewModel = hiltViewModel()) {
    val product by viewModel.selectedProduct.collectAsState()

    val favoriteItems by viewModel.favoriteItems.collectAsState(initial = listOf())
    val isFavorite = remember { mutableStateOf(false) }
    val context= LocalContext.current

    LaunchedEffect(favoriteItems, product) {
        isFavorite.value = product != null && favoriteItems.any { it.id == product!!.id }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(productDetailColumnPadding)
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = product!!.image,
            contentDescription = stringResource(id = R.string.product_detail_content_description),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        ProductTitleText(
            title = product!!.title,
            overflow = null,
            modifier = Modifier.padding(top = productDetailProductTitleTextPaddingTop)
        )
        ProductPriceText(
            price = product!!.price,
            modifier = Modifier.padding(top = productDetailProductPriceTextPaddingTop)
        )
        ProductDescriptionText(
            description = product!!.description,
            overflow = null,
            color = Color.DarkGray,
            modifier = Modifier.padding(top = productDetailProductDescriptionTextPaddingTop)
        )

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = productDetailRowPaddingTop),
            horizontalArrangement = Arrangement.spacedBy(productDetailRowHorizontalArrangement)
        ) {
            CartButton(
                onClick = { viewModel.addToCart(product!!) },
                modifier = Modifier.width(productDetailCartButtonWith),
                iconSize = productDetailCartButtonIconSize
            )
            FavoriteButton(
                isFavorite = isFavorite.value,
                onFavoriteToggle = {
                    viewModel.toggleFavorite(product!!)
                    if (isFavorite.value){
                        Toast.makeText(context, R.string.removed_from_favorites, Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(context, R.string.added_to_favorites, Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
            )
        }
    }
}