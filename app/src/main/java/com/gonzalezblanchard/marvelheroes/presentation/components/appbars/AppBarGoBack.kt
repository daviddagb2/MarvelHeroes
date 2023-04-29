package com.gonzalezblanchard.marvelheroes.presentation.components.appbars

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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