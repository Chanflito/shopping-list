package com.example.shopping_list.ui.composable.cart.product

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.shopping_list.ui.theme.Blue40

@Composable
fun CartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    containerColor: Color = Blue40,
    contentColor: Color = Color.White,
    iconSize: Dp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .wrapContentHeight(),
        colors = ButtonDefaults.buttonColors(
            containerColor,
            contentColor
        )
    ) {
        Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "", Modifier.size(iconSize))
    }
}