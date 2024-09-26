package com.onekamardin.learningcard.features.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.onekamardin.learningcard.features.Screen2
import com.onekamardin.learningcard.features.Screen3
import com.onekamardin.learningcard.features.words_screen.WordsScreen
import com.onekamardin.learningcard.features.words_screen.WordsScreenViewModel
import com.onekamardin.learningcard.features.screen4.Screen4
import com.onekamardin.learningcard.navigation.BottomNavigationBar
import com.onekamardin.learningcard.navigation.NavigationGraph
import com.onekamardin.learningcard.navigation.rememberNavigationState

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()
    val viewModel: WordsScreenViewModel = hiltViewModel()


    Scaffold(
        bottomBar = {
            BottomNavigationBar(navigationState)
        }
    ) { paddingValues ->
        NavigationGraph(
            navHostController = navigationState.navHostController,
            screen1Content = { WordsScreen() },
            screen2Content = { Screen2() },
            screen3Content = { Screen3() },
            screen4Content = { Screen4() },
        )

    }
}


