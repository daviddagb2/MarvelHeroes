package com.gonzalezblanchard.marvelheroes.presentation.components.appbars

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.gonzalezblanchard.marvelheroes.ui.theme.colorHeaderMarvel
import com.gonzalezblanchard.marvelheroes.R

@Composable
fun AppBarGoBack(title:String, onBackClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.marvel_bold)),
                    fontSize = 24.sp,
                    color = Color.White,
                ),
            )
        },
        backgroundColor = colorHeaderMarvel,
        navigationIcon = {
            IconButton(
                onClick = { onBackClicked() }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        },

        )

}