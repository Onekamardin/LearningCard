package com.onekamardin.learningcard.features.main

import com.onekamardin.learningcard.data.model.Dict

sealed class MainScreenState {


    object FeedScreen : MainScreenState()

    data class DictionariesScreen(val dict: List<Dict>) : MainScreenState()

}