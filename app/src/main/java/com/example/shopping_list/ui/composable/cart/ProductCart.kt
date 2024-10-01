package com.example.shopping_list.ui.composable.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import coil.compose.AsyncImage
import com.example.shopping_list.R
import com.example.shopping_list.data.CartProduct
import com.example.shopping_list.ui.composable.favorite.FavoriteButton
import com.example.shopping_list.ui.composable.product.ProductDescriptionText
import com.example.shopping_list.ui.theme.counterIconButtonWidth
import com.example.shopping_list.ui.theme.productCartCardAsyncImagePadding
import com.example.shopping_list.ui.theme.productCartCardAsyncImageSize
import com.example.shopping_list.ui.theme.productCartCardColumnPadding
import com.example.shopping_list.ui.theme.productCartCardColumnWeight
import com.example.shopping_list.ui.theme.productCartCardElevation
import com.example.shopping_list.ui.theme.productCartCardPadding
import com.example.shopping_list.ui.theme.productCartCardSpacerHeight


@Composable
fun ProductCartCard(
    product: CartProduct,
    onAddToFavorites: () -> Unit,
    onRemove: () -> Unit,
    isFavorite: Boolean,
    onQuantityChange: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(productCartCardPadding),
        elevation = CardDefaults.cardElevation(productCartCardElevation),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(productCartCardColumnPadding)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model= product.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(productCartCardAsyncImageSize)
                        .padding(end = productCartCardAsyncImagePadding)
                )

                Column(
                    modifier = Modifier.weight(productCartCardColumnWeight)
                ) {
                    Text(
                        text = product.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "$${product.price}",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(productCartCardSpacerHeight))

            Column {
                ProductDescriptionText(modifier = Modifier, description = product.description, overflow = null , color = Color.Black)
            }
            Spacer(modifier = Modifier.height(productCartCardSpacerHeight))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Counter(
                    currentQuantity = product.quantity,
                    onQuantityChange = onQuantityChange
                )
                FavoriteButton(
                    onFavoriteToggle = {
                        onAddToFavorites()
                    },
                    isFavorite = isFavorite
                )
                IconButton(onClick = onRemove) {
                    Icon(Icons.Default.Delete, contentDescription = stringResource(id = R.string.content_description_remove))
                }
            }
        }
    }
}

@Composable
fun Counter(
    currentQuantity: Int,
    onQuantityChange: (Int) -> Unit
) {
    var count by remember { mutableIntStateOf(currentQuantity) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        IconButton(
            onClick = {
                if (count > 1) {
                    count--
                    onQuantityChange(count)
                }
            },
            modifier = Modifier.width(counterIconButtonWidth)
        ) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = stringResource(id = R.string.content_description_decrease))
        }

        Text(text = "$count")

        IconButton(
            onClick = {
                count++
                onQuantityChange(count)
            },
            Modifier.width(counterIconButtonWidth)
        ) {
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = stringResource(id = R.string.content_description_increase))
        }
    }
}