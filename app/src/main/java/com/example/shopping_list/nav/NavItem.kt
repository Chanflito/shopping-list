package com.example.shopping_list.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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

    data object Profile :
        NavItem(path = NavPath.PROFILE.toString(), title = NavTitle.PROFILE, icon= Icons.Default.AccountCircle)

    data object ProductDetail :
        NavItem(path = NavPath.PRODUCT_DETAIL.toString(), title = null, icon = null)
}
