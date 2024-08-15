package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.shopping_list.R
import com.example.shopping_list.ui.composable.ProductViewModel

@Composable
fun ProductDetail(productViewModel: ProductViewModel){
    val product= productViewModel.getProduct()
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(8.dp, bottom = 88.dp)
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
        CartButton(onClick = { },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(112.dp)
                .padding(top = 16.dp),
            iconSize = 24.dp
        )
    }
}