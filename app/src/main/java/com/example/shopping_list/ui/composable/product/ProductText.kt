package com.example.shopping_list.ui.composable.product

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.shopping_list.R
import com.example.shopping_list.ui.theme.productPriceTextFontSize
import com.example.shopping_list.ui.theme.productTitleTextFontSize

@Composable
fun ProductTitleText(
    modifier: Modifier,
    title: String,
    overflow: TextOverflow?)
{
    Text(
        text = title,
        fontSize = productTitleTextFontSize,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        maxLines = when (overflow) {
            TextOverflow.Ellipsis -> 1
            else -> Int.MAX_VALUE
        },
        overflow = overflow ?: TextOverflow.Visible
    )
}

@Composable
fun ProductPriceText(
    modifier: Modifier,
    price: Double)
{
    Text(
        text = stringResource(id = R.string.product_price_text, price),
        fontSize = productPriceTextFontSize,
        fontWeight = FontWeight.Medium,
        modifier = modifier,
    )
}

@Composable
fun ProductDescriptionText(
    modifier: Modifier,
    description: String,
    overflow: TextOverflow?,
    color: Color?
)
{
    Text(
        text = description,
        color = color ?: Color.Gray,
        modifier = modifier,
        maxLines = when (overflow) {
            TextOverflow.Ellipsis -> 1
            else -> Int.MAX_VALUE
        },
        overflow = overflow ?: TextOverflow.Visible
    )
}