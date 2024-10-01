package com.example.shopping_list.ui.composable.product

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.shopping_list.R
import com.example.shopping_list.ui.theme.Blue40
import com.example.shopping_list.ui.theme.cartButtonBorderStroke

@Composable
fun CartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    borderColor: Color = Blue40,
    iconColor: Color = Blue40,
    containerColor: Color = Color.White,
    iconSize: Dp
) {
    val context= LocalContext.current
    Button(
        onClick ={
            onClick()
            Toast.makeText(
                context,
                context.getString(R.string.product_added_to_cart),
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = modifier
            .wrapContentHeight(),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = iconColor
        ),
        border = BorderStroke(cartButtonBorderStroke, borderColor)
    ) {
        Icon(
            imageVector = Icons.Filled.ShoppingCart,
            contentDescription = "",
            modifier = Modifier.size(iconSize)
        )
    }
}