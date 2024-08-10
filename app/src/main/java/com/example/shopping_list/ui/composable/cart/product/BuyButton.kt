package com.example.shopping_list.ui.composable.cart.product

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shopping_list.ui.theme.Blue40

@Composable
fun BuyButton(
    modifier: Modifier = Modifier,
    text: String = "Buy",
    onClick: () -> Unit,
    containerColor: Color = Blue40,
    contentColor: Color = Color.White
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor,
            contentColor
        )
    ) {
        Text(text = text)
    }
}