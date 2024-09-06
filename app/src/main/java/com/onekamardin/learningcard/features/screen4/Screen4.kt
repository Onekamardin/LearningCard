package com.example.learningcard.features.screen4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Screen4() {

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.fillMaxSize().wrapContentHeight(),
            text = "Screen4",
            textAlign = TextAlign.Center,
        )
        Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) { }
    }

}