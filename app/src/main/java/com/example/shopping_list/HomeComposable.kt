package com.example.shopping_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home() {
    val buttons = listOf<HomeButton>(
        HomeButton(
            leadingIcon = Icons.Filled.Person,
            trailingIcon = Icons.Filled.KeyboardArrowRight,
            title = stringResource(id = R.string.profile),
            onClick = {}
        ),
        HomeButton(
            leadingIcon = Icons.Filled.ShoppingCart,
            trailingIcon = Icons.Filled.KeyboardArrowRight,
            title = stringResource(id = R.string.cart),
            onClick = {}
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            buttons.forEach { button ->
                ButtonWithIcons(
                    leadingIcon = button.leadingIcon,
                    title = button.title,
                    trailingIcon = button.trailingIcon
                )
            }
        }
    }
}

@Composable
fun ButtonWithIcons(
    leadingIcon: ImageVector,
    title: String,
    trailingIcon: ImageVector,
) {
    Button(onClick = {}, modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = leadingIcon, contentDescription = "")
            Text(text = title)
            Icon(imageVector = trailingIcon, contentDescription = "")
        }
    }
}

@Preview
@Composable
fun PreviewHome() {
    Home()
}

data class HomeButton(
    val leadingIcon: ImageVector,
    val trailingIcon: ImageVector,
    val title: String,
    val onClick: () -> Unit,
)