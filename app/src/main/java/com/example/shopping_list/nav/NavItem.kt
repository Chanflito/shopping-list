package com.example.shopping_list.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart


sealed class NavItem {
    object Home :
        Item(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Default.Home)

    object Cart :
        Item(path = NavPath.CART.toString(), title = NavTitle.SEARCH, icon = Icons.Default.ShoppingCart)

    object Order :
        Item(path = NavPath.ORDER.toString(), title = NavTitle.ORDER, icon = Icons.Default.Person)
}