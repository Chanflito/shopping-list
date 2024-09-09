package com.example.shopping_list.ui.composable

import android.annotation.SuppressLint
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.shopping_list.nav.BottomNavigationBar
import com.example.shopping_list.nav.NavigationScreens
import com.example.shopping_list.nav.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {

//    val currentBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = currentBackStackEntry?.destination?.route ?: ""
    Scaffold(
//        topBar = {
//            if (currentRoute == "home") {
//                TopBar(
//                    searchCharSequence = { /* Handle search */ },
//                    onCartIconClick = { /* Handle cart icon click */ }
//                )
//            }
//        },
        bottomBar = {
            BottomAppBar { BottomNavigationBar(navController = navController) }
        }
    ) { innerPadding ->
        NavigationScreens(navController = navController, innerPadding)
    }
}