package com.example.shopping_list.ui.composable.product

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import com.example.shopping_list.R
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.theme.productCardAsyncImageHeight
import com.example.shopping_list.ui.theme.productCardAsyncImageWidth
import com.example.shopping_list.ui.theme.productCardButtonPaddingBottom
import com.example.shopping_list.ui.theme.productCardButtonPaddingTop
import com.example.shopping_list.ui.theme.productCardButtonWidth
import com.example.shopping_list.ui.theme.productCardColumnPaddingEnd
import com.example.shopping_list.ui.theme.productCardColumnPaddingStart
import com.example.shopping_list.ui.theme.productCardColumnPaddingTop
import com.example.shopping_list.ui.theme.productCardDescriptionTextPaddingTop
import com.example.shopping_list.ui.theme.productCardElevation
import com.example.shopping_list.ui.theme.productCardModifierHeight
import com.example.shopping_list.ui.theme.productCardPriceTextPaddingTop
import com.example.shopping_list.ui.theme.productCardShape
import com.example.shopping_list.ui.theme.productCardTitleTextPaddingTop


@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    cardButton: @Composable (modifier: Modifier) -> Unit
) {
    Card(
        shape = RoundedCornerShape(productCardShape),
        elevation = CardDefaults.cardElevation(productCardElevation),
        modifier = Modifier
            .fillMaxWidth()
            .height(productCardModifierHeight)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = productCardColumnPaddingStart,
                    end = productCardColumnPaddingEnd,
                    top = productCardColumnPaddingTop)
        ) {

            AsyncImage(
                model = product.image,
                contentDescription = stringResource(id = R.string.product_image_content_description),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(productCardAsyncImageHeight)
                    .width(productCardAsyncImageWidth),
                contentScale = ContentScale.Fit
            )

            ProductTitleText(
                title = product.title,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = productCardTitleTextPaddingTop)
            )

            ProductPriceText(price = product.price, modifier = Modifier.padding(top = productCardPriceTextPaddingTop))

            ProductDescriptionText(
                description = product.description,
                overflow = TextOverflow.Ellipsis,
                color = null,
                modifier = Modifier.padding(top =productCardDescriptionTextPaddingTop)
            )

            cardButton(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = productCardButtonPaddingTop,
                        bottom = productCardButtonPaddingBottom)
                    .width(productCardButtonWidth)
            )
        }
    }
}