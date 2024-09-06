package com.onekamardin.learningcard.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    screen1Content: @Composable () -> Unit,
    screen2Content: @Composable () -> Unit,
    screen3Content: @Composable () -> Unit,
    screen4Content: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.Screen1.route,
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
        composable(BottomNavItem.Screen1.route) {
            screen1Content()
        }
        composable(BottomNavItem.Screen2.route) {
            screen2Content()
        }
        composable(BottomNavItem.Screen3.route) {
            screen3Content()
        }
        composable(BottomNavItem.Screen4.route) {
            screen4Content()
        }
    }
}