package com.example.learningcard.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningcard.ui.theme.BlueWord

@Preview(showBackground = true)
@Composable
fun UiWordItem() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(end = 50.dp)
            .height(450.dp)
            .width(300.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(BlueWord)
    ) {
        Text(
            text = "Word",
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

