package com.onekamardin.learningcard.features

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Screen3() {

    Text(
        modifier = Modifier.fillMaxSize().wrapContentHeight(),
        text = "Screen3",
        textAlign = TextAlign.Center)
}