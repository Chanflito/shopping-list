package com.example.shopping_list.ui.composable

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopping_list.nav.NavItem
import com.example.shopping_list.ui.composable.cart.CartScreen
import com.example.shopping_list.ui.composable.product.ProductDetail
import com.example.shopping_list.ui.composable.home.HomeScreen
import com.example.shopping_list.ui.composable.favorite.FavoriteScreen

@Composable
fun NavigationScreens(navController: NavHostController) {
    val productViewModel: ProductViewModel = viewModel()

    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.Home.path) { HomeScreen(navController, productViewModel) }
        composable(NavItem.Cart.path) { CartScreen() }
        composable(NavItem.Favorite.path) { FavoriteScreen(navController,productViewModel) }
        composable("productDetail"){ ProductDetail(productViewModel) }
    }
}