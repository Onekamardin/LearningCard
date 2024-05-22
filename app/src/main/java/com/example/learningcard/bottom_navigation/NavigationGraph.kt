package com.example.learningcard.bottom_navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learningcard.features.Screen1
import com.example.learningcard.features.Screen2
import com.example.learningcard.features.Screen3
import com.example.learningcard.features.Screen4

@Composable
fun NavigationGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = "screen1",
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                animationSpec = tween(700)
            )
        })
    {
        composable("screen1") {
            Screen1()
        }
        composable("screen2") {
            Screen2()
        }
        composable("screen3") {
            Screen3()
        }
        composable("screen4") {
            Screen4()
        }
    }
}