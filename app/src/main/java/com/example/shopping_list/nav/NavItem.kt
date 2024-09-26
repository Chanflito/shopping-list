package com.example.shopping_list.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.shopping_list.R


sealed class NavItem(val path: String, val title: String?, val icon: ImageVector?) {
    data object Home :
        NavItem(path = NavPath.HOME.toString(), title = NavTitle.HOME, icon = Icons.Default.Home)

    data object Cart :
        NavItem(path = NavPath.CART.toString(), title = NavTitle.CART, icon = Icons.Default.ShoppingCart)

    data object Favorite :
        NavItem(path = NavPath.FAVORITE.toString(), title = NavTitle.FAVORITE, icon = Icons.Default.FavoriteBorder)

    class ShoppingBag(icon: ImageVector) :
        NavItem(path = NavPath.SHOPPING_BAG.toString(),// TODO: CHANGE THIS
            title = NavTitle.BAG,
            icon = icon
        )

    data object ProductDetail :
        NavItem(path = NavPath.PRODUCT_DETAIL.toString(), title = null, icon = null)
}

@Composable
fun shoppingBagNavItem(): NavItem.ShoppingBag {
    val icon = ImageVector.vectorResource(id = R.drawable.bag_shopping_list_com)
    return NavItem.ShoppingBag(icon = icon)
}