package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping_list.R
import com.example.shopping_list.model.Product


@Composable
fun ProductCard(
    product: Product,
    onClick: ()-> Unit,
    cardButton: @Composable (modifier: Modifier) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(272.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp, top = 20.dp)) {

            Image(
                painter = painterResource(id = R.drawable.sample_image),
                contentDescription = "content",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .width(100.dp),
                contentScale = ContentScale.Fit
            )

            ProductTitleText(title = product.title ,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )

            ProductPriceText(price = product.price, modifier = Modifier.padding(top = 8.dp))

            ProductDescriptionText(description = product.description,
                overflow = TextOverflow.Ellipsis,
                color = null,
                modifier = Modifier.padding(top = 8.dp)
            )
            cardButton(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp, bottom = 8.dp)
                    .width(104.dp)
            )

        }
    }
}