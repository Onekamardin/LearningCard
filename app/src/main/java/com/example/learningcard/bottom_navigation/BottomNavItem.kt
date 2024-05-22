package com.example.learningcard.bottom_navigation

import com.example.learningcard.R

sealed class BottomNavItem(val title: String, val iconId: Int, val route: String) {
    object Screen1: BottomNavItem("Screen1", R.drawable.ic, "screen1")
    object Screen2: BottomNavItem("Screen2", R.drawable.ic, "screen2")
    object Screen3: BottomNavItem("Screen3", R.drawable.ic, "screen3")
    object Screen4: BottomNavItem("Screen4", R.drawable.ic, "screen4")
}