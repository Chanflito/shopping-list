package com.example.shopping_list.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shopping_list.data.CartProduct
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.composable.cart.TotalPriceCard
import com.example.shopping_list.ui.composable.cart.ProductCartCard
import com.example.shopping_list.ui.composable.product.CartButton
import com.example.shopping_list.ui.composable.product.ProductCard


@Preview
@Composable
fun ProductCartCardPreview() {
    val sampleProduct =
        CartProduct(
            id = 1,
            image = "some image url",
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            price = 19.2,
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
            quantity = 5
        )
    ProductCartCard(
        product = sampleProduct,
        onAddToFavorites = {  },
        onRemove = {  },
        isFavorite = true
    ) {

    }
}

@Preview
@Composable
fun ProductCardPreview() {
    val sampleProduct =
        Product(
            id = 1,
            image = "some image url",
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            price = 19.2,
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        )
    ProductCard(product = sampleProduct, onClick = { /*TODO*/ }, cardButton = { modifier ->
        CartButton(
            modifier = modifier,
            onClick = {
            },
            iconSize = 24.dp
        )
    })
}


@Preview
@Composable
fun AddToShoppingListCardPreview() {
    TotalPriceCard(totalPrice = 20.2)
}
