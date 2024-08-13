package com.example.shopping_list.ui.composable.product

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.unit.dp
import com.example.shopping_list.ui.theme.Blue40

@Composable
fun CartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    borderColor: Color = Blue40,
    iconColor: Color = Blue40,
    containerColor: Color = Color.White,
    iconSize: Dp
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .wrapContentHeight(),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = iconColor
        ),
        border = BorderStroke(2.dp, borderColor) // Define el grosor y color del borde
    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "",
            modifier = Modifier.size(iconSize)
        )
    }
}