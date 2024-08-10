package com.example.shopping_list.ui.composable.cart.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopping_list.R

@Composable
@Preview
fun ProductDetail(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(8.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.sample_image),
            contentDescription = "Description",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        ProductTitleText(title = "Title", overflow = null, modifier = Modifier.padding(top = 16.dp))
        ProductPriceText(price = 15.2 , modifier = Modifier.padding(top = 16.dp))
        ProductDescriptionText(
            description = "Lorem Ipsum es simplemente el texto de relleno de las" +
                    " imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, " +
                    "cuando un impresor (N. del T. persona que se dedica a la imprenta) " +
                    "desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen." +
                    " No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando " +
                    "esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", " +
                    "las cuales contenian pasajes de Lorem Ipsum, y " +
                    "más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.",
            overflow = null, color = Color.DarkGray , modifier = Modifier.padding(top = 16.dp)
        )
        CartButton(onClick = { },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(112.dp)
                .padding(top = 16.dp),
            iconSize = 24.dp
        )
    }
}