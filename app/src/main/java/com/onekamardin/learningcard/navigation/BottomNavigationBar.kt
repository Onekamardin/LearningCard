package com.onekamardin.learningcard.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.onekamardin.learningcard.ui.theme.BlueWord
import com.onekamardin.learningcard.ui.theme.PurpleGrey80


@Composable
fun BottomNavigationBar(navigationState: NavigationState) {
    val listBottomItem = listOf(
        BottomNavItem.Screen1,
        BottomNavItem.Screen2,
        BottomNavItem.Screen3,
        BottomNavItem.Screen4
    )
    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val backStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        listBottomItem.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navigationState.navigateTo(item.route)
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