package com.example.shopping_list.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopping_list.ui.composable.CartViewModel
import com.example.shopping_list.ui.composable.ProductViewModel
import com.example.shopping_list.ui.composable.cart.CartScreen
import com.example.shopping_list.ui.composable.product.ProductDetail
import com.example.shopping_list.ui.composable.home.HomeScreen
import com.example.shopping_list.ui.composable.favorite.FavoriteScreen
import com.example.shopping_list.ui.composable.favorite.FavoriteViewModel

@Composable
fun NavigationScreens(navController: NavHostController, innerPadding: PaddingValues) {
//    val productViewModel: ProductViewModel = viewModel()
//    val cartViewModel: CartViewModel = viewModel()
    val favoriteViewModel: FavoriteViewModel= viewModel()

    NavHost(navController, startDestination = NavItem.Home.path, modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        composable(NavItem.Home.path) { HomeScreen {
            navController.navigate(NavItem.ProductDetail.path) {
            }
        } }
        composable(NavItem.Cart.path) { CartScreen(favoriteViewModel = favoriteViewModel) }
        composable(NavItem.Favorite.path) { FavoriteScreen({navController.navigate(NavItem.ProductDetail.path)},favoriteViewModel)}
        composable(NavItem.ProductDetail.path){ ProductDetail() }
    }
}