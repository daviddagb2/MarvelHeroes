package com.gonzalezblanchard.marvelheroes.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gonzalezblanchard.marvelheroes.R

@Preview
@Composable
fun TitleText(
    value: String ="margin",
) {

    Text(
        modifier = Modifier.padding(start = 10.dp, end = 10.dp, top =8.dp, bottom = 8.dp),
        text = value,
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.marvel_bold)),
            fontSize = 24.sp,
            color = Color.White,
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )

}
