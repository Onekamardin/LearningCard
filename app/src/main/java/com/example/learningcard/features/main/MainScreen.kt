package com.example.learningcard.features.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.learningcard.bottom_navigation.BottomNavigationBar
import com.example.learningcard.bottom_navigation.NavigationGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        NavigationGraph(navHostController = navController)

    }
}