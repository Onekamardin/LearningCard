package com.onekamardin.learningcard.features.words_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.onekamardin.learningcard.data.model.Dict


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionariesListScreen(
    viewModel: WordsScreenViewModel = hiltViewModel(),
    sheetState: SheetState
) {
    val dictionaries = viewModel.dictionary.collectAsState(listOf())
    val isOpened = viewModel.isBottomSheetOpened.collectAsState(false)

    if (isOpened.value) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                // почему я не могу здесь использовать "isOpened"?????
                viewModel.isBottomSheetOpened.value = false
            }) {
            LazyColumn(
                modifier = Modifier.padding(bottom = 35.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(dictionaries.value) {
                    DictItem(dict = it) {
                        viewModel.isBottomSheetOpened.value = false
                    }
                }
            }
        }
    }
}

@Composable
private fun DictItem(
    dict: Dict,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(5.dp),

        ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = dict.title,
                color = Color.White,
                fontSize = 36.sp
            )
        }

    }
}

