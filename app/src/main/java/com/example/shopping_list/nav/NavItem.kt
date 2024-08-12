package com.example.shopping_list.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart


sealed class NavItem {
    object Home :
        Item(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Default.Home)

    object Cart :
        Item(path = NavPath.CART.toString(), title = NavTitle.CART, icon = Icons.Default.ShoppingCart)

    object Favorite :
        Item(path = NavPath.FAVORITE.toString(), title = NavTitle.FAVORITE, icon = Icons.Default.FavoriteBorder)
}