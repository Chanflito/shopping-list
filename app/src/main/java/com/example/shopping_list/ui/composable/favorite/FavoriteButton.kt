package com.example.shopping_list.ui.composable.favorite

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.shopping_list.R
import com.example.shopping_list.ui.theme.Blue40

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    modifier: Modifier = Modifier,
    onFavoriteToggle: () -> Unit
) {
    IconButton(onClick = onFavoriteToggle, modifier) {
        Icon(
            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
            contentDescription = stringResource(
                id = if (isFavorite) R.string.content_description_not_favorite else R.string.content_description_favorite
            ),
            tint = if (isFavorite) Blue40 else Color.Gray
        )
    }
}