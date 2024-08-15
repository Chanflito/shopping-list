package com.example.shopping_list.ui.composable.favorite

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.shopping_list.model.Product
import com.example.shopping_list.ui.composable.ProductViewModel
import com.example.shopping_list.ui.composable.product.FavoriteProductGrid

@Composable
fun FavoriteScreen(navController: NavController, productViewModel: ProductViewModel) {
    val sampleProducts = listOf(
        Product(
            id= 1,
            imageUrl = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
            title = "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
            price = 19.2,
            description = "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
        ),
        Product(
            id = 2,
            imageUrl = "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
            title = "Mens Casual Premium Slim Fit T-Shirts ",
            price = 22.3,
            description = "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing." +
                    " And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans." +
                    " The Henley style round neckline includes a three-button placket.",
        ),
        Product(
            id = 3,
            imageUrl = "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
            title = "Mens Cotton Jacket",
            price = 55.99,
            description = "great outerwear jackets for Spring/Autumn/Winter, suitable for many occasions, such as working, hiking, camping, mountain/rock climbing, cycling, traveling or other outdoors. Good gift choice for you or your family member." +
                    " A warm hearted love to Father, husband or son in this thanksgiving or Christmas Day.",
        ),
        Product(
            id = 4,
            imageUrl = "https://fakestoreapi.com/img/71YXzeOuslL._AC_UY879_.jpg",
            title = "Mens Casual Slim Fit",
            price = 15.99,
            description = "The color could be slightly different between on the screen and in practice. / Please note that body builds vary by person, therefore, detailed size information should be reviewed below on the product description.",
        )

    )

    FavoriteProductGrid(
        products = sampleProducts,
        navController,
        productViewModel
    )
}