package com.example.shopping_list.ui.composable

import android.annotation.SuppressLint
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.shopping_list.nav.BottomNavigationBar
import com.example.shopping_list.nav.NavigationScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(bottomBar = {
        BottomAppBar { BottomNavigationBar(navController = navController) }
    })
    { innerPadding ->
        NavigationScreens(navController = navController,innerPadding)
    }

}