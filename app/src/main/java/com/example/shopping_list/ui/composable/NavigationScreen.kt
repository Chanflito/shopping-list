package com.example.shopping_list.ui.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shopping_list.nav.NavItem
import com.example.shopping_list.ui.composable.tab.CartScreen
import com.example.shopping_list.ui.composable.tab.HomeScreen
import com.example.shopping_list.ui.composable.tab.OrderScreen

@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.Home.path) { HomeScreen() }
        composable(NavItem.Cart.path) { CartScreen() }
        composable(NavItem.Order.path) { OrderScreen() }
    }
}