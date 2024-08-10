package com.example.shopping_list.ui.composable.tab

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopping_list.R
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.theme.Blue40

@Composable
fun CartScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 80.dp)
    ) {
        ProductGridPreview()
    }
}

@Composable
fun ProductCard(
    product: Product,
    onBuyClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp, top = 20.dp)) {
            Image(
                painter = painterResource(id = R.drawable.sample_image),
                contentDescription = "content",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .width(100.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = product.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp),
                maxLines = 1
            )
            Text(
                text = "Precio : $${product.price}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 16.dp)
            )
            Button(
                onClick = onBuyClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue40,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Comprar")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    val sampleProduct = Product(
        imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
        title = "Iphone",
        price = 19.2
    )
    ProductCard(
        product = sampleProduct,
        onBuyClick = {  }
    )
}

@Composable
fun ProductGrid(
    products: List<Product>,
    onBuyClick: (Product) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                onBuyClick = { onBuyClick(product) }
            )
        }
    }
}
@Composable
//@Preview
fun ProductGridPreview() {

    val sampleProducts = listOf(
        Product(
            imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            title = "Iphone",
            price = 19.2
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy",
            price = 29.99
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy",
            price = 29.99
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy",
            price = 29.99
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy aaaaaadasdasdaddsda",
            price = 29.99
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy",
            price = 29.99
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy",
            price = 29.99
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy",
            price = 29.99
        ),
        Product(
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Samsung Galaxy",
            price = 29.99
        )

    )

    ProductGrid(
        products = sampleProducts,
        onBuyClick = { /* Acción de compra */ }
    )
}