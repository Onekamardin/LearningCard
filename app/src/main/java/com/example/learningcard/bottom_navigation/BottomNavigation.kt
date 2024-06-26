package com.example.learningcard.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.learningcard.ui.theme.BlueWord
import com.example.learningcard.ui.theme.PurpleGrey80

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val listBottomItem = listOf(
        BottomNavItem.Screen1,
        BottomNavItem.Screen2,
        BottomNavItem.Screen3,
        BottomNavItem.Screen4
    )
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        listBottomItem.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = "bottom_icon"
                    )
                },
                label = {
                    Text(text = item.title, fontSize = 9.sp)
                },
                selectedContentColor = BlueWord,
                unselectedContentColor = PurpleGrey80
            )
        }
    }

}