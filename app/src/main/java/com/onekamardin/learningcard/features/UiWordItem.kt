package com.onekamardin.learningcard.features

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onekamardin.learningcard.ui.theme.BlueWord

@Preview(showBackground = true)
@Composable
fun UiWordItem() {
    Column(
        modifier = Modifier
            .padding(end = 25.dp)
            .height(250.dp)
            .width(450.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(BlueWord)
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            text = "Word",
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "[transcription]",
            fontSize = 28.sp,
            color = Color.White,
            textAlign = TextAlign.Center,

            )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "translate 1",
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        Text(
            modifier = Modifier.padding(start = 20.dp),
            text = "translate 2",
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}

