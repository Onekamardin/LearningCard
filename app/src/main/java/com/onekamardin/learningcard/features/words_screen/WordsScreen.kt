package com.onekamardin.learningcard.features.words_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.onekamardin.learningcard.features.UiWordItem
import com.onekamardin.learningcard.ui.theme.BlueMain
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun WordsScreen(
) {
//    val words = viewModel.words.collectAsState(initial = emptyList())
    //val dictionaries = viewModel.dictionary.collectAsState(emptyList())
    // val screenState = viewModel.screenState.collectAsState(MainScreenState.FeedScreen)

//    when (screenState.value) {
//        is MainScreenState.FeedScreen -> {
//            FeedScreen()
//        }
//
//        is MainScreenState.DictionariesScreen -> {
//            DictionariesListScreen()
//            BackHandler {
//                viewModel.closeDictionariesScreen()
//            }
//        }
//    }
    val sheetState = rememberModalBottomSheetState()

    WordsScreenContent()
    DictionariesListScreen(sheetState = sheetState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun WordsScreenContent(
    viewModel: WordsScreenViewModel = hiltViewModel()
) {

    val pagerState = rememberPagerState(pageCount = { 10 })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueMain)
            .padding(top = 80.dp, start = 25.dp)
    ) {
        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Изучение слов",
                fontSize = 26.sp,
                color = Color.White,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            IconButton(
                modifier = Modifier.padding(start = 100.dp),
                onClick = {
                }) {
                Icon(
                    Icons.Default.Settings,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Row(
            modifier = Modifier.clickable {
                viewModel.isBottomSheetOpened.value = true
                viewModel.loadDictionaries()
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Англо-русский",
                    fontSize = 26.sp,
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = "Всего слов:",
                    fontSize = 24.sp,
                    color = Color.White,
                )
                Text(
                    text = "Изучено слов:",
                    fontSize = 24.sp,
                    color = Color.White,
                )
            }
            IconButton(
                modifier = Modifier.padding(start = 100.dp),
                onClick = { }
            ) {
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill,
            contentPadding = PaddingValues(top = 150.dp)
        ) { page ->
            UiWordItem()
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(
                modifier = Modifier.padding(start = 35.dp),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "word_back",
                    tint = Color.White
                )
            }
            IconButton(
                modifier = Modifier.padding(end = 35.dp),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }) {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = "word_next",
                    tint = Color.White
                )
            }
        }
    }
}




