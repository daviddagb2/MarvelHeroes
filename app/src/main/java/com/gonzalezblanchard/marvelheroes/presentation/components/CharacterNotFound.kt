package com.gonzalezblanchard.marvelheroes.presentation.components

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.gonzalezblanchard.marvelheroes.R
import com.gonzalezblanchard.marvelheroes.ui.theme.red

@Composable
fun CharacterNotFound() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxHeight()
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(R.drawable.baseline_wifi_off_24),
                contentDescription = "Not Found"
            )

            Text(
                text = stringResource(R.string.str_not_foud),
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.marvel_bold)),
                    fontSize = 24.sp,
                    color = Color.White,
                ),
                textAlign = TextAlign.Center
            )

        }


    }
}