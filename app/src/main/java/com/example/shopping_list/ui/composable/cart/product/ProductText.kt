package com.example.shopping_list.ui.composable.cart.product

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun ProductTitleText(
    modifier: Modifier,
    title: String,
    overflow: TextOverflow?)
{
    Text(
        text = title,
        fontSize = 20.sp,
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
        text = "Price: $${price}",
        fontSize = 16.sp,
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