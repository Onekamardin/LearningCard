package com.example.learningcard.features.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.learningcard.features.Screen2
import com.example.learningcard.features.Screen3
import com.example.learningcard.features.Screen4
import com.example.learningcard.features.screen1.Screen1
import com.example.learningcard.navigation.BottomNavigationBar
import com.example.learningcard.navigation.NavigationGraph
import com.example.learningcard.navigation.rememberNavigationState

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()


    Scaffold(
        bottomBar = {
            BottomNavigationBar(navigationState)
        }
    ) { paddingValues ->
        NavigationGraph(
            navHostController = navigationState.navHostController,
            screen1Content = { Screen1() },
            screen2Content = { Screen2() },
            screen3Content = { Screen3() },
            screen4Content = { Screen4() },
        )

    }
}


