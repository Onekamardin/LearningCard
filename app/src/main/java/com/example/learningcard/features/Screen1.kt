package com.example.learningcard.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningcard.ui.theme.BlueMain

@Preview(showBackground = true)
@Composable
fun Screen1() {

    Column(
        modifier = Modifier
            .background(BlueMain)
    ) {
        LazyRow(
            contentPadding = PaddingValues(top = 150.dp, start = 50.dp, end = 50.dp)
        ) {
            items(10) {
                UiWordItem()
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                modifier = Modifier.padding(start = 35.dp),
                onClick = { }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "word_back",
                    tint = Color.White
                )
            }
            IconButton(
                modifier = Modifier.padding(end = 35.dp),
                onClick = { }) {
                Icon(
                    Icons.Default.PlayArrow,
                    contentDescription = "word_next",
                    tint = Color.White
                )
            }
        }
    }
}