package com.gonzalezblanchard.marvelheroes.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyText(title:String, color: Color, style: TextStyle, lines:Int = Int.MAX_VALUE){
    Text(text = title, color = color, style = style, maxLines = lines, modifier = Modifier.fillMaxWidth())
}

@Preview
@Composable
fun PreviewMyText(){
    MyText(title = "Titulo",
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.subtitle1)
}