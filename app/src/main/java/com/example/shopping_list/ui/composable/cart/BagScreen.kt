package com.example.shopping_list.ui.composable.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping_list.R
import com.example.shopping_list.ui.theme.bagScreenFontSize
import com.example.shopping_list.ui.theme.bagScreenPadding

@Composable
fun BagScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = stringResource(id = R.string.empty_bag),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bagScreenPadding),
            style = TextStyle(
                fontSize = bagScreenFontSize,
                fontWeight = FontWeight.Bold
            )
        )
    }
}