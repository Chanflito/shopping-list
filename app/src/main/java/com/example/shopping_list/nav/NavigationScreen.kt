package com.example.shopping_list.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopping_list.ui.composable.cart.BagScreen
import com.example.shopping_list.ui.composable.cart.CartScreen
import com.example.shopping_list.ui.composable.product.ProductDetail
import com.example.shopping_list.ui.composable.home.HomeScreen
import com.example.shopping_list.ui.composable.favorite.FavoriteScreen

@Composable
fun NavigationScreens(navController: NavHostController, innerPadding: PaddingValues) {

    NavHost(navController, startDestination = NavItem.Home.path, modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)) {
        composable(NavItem.Home.path) {
            HomeScreen(
                onNavigateToProductDetail = {
                    navController.navigate(NavItem.ProductDetail.path)
                },
                onNavigateToCart = {
                    navController.navigate(NavItem.Cart.path)
                }
            )
        }
        composable(NavPath.SHOPPING_BAG.toString()) { BagScreen()}
        composable(NavPath.CART.toString()){ CartScreen()}
        composable(NavPath.FAVORITE.toString()) { FavoriteScreen({
            navController.navigate(NavItem.ProductDetail.path)
        })}
        composable(NavPath.PRODUCT_DETAIL.toString()){ ProductDetail() }
    }
}