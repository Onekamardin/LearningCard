package com.onekamardin.learningcard.navigation

import com.onekamardin.learningcard.R

sealed class BottomNavItem(val title: String, val iconId: Int, val route: String) {
    object WordsScreen: BottomNavItem("Words", R.drawable.ic, "words_screen")
    object Screen2: BottomNavItem("Screen2", R.drawable.ic, "screen2")
    object Screen3: BottomNavItem("Screen3", R.drawable.ic, "screen3")
    object Screen4: BottomNavItem("Screen4", R.drawable.ic, "screen4")
}