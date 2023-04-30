package com.gonzalezblanchard.marvelheroes.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gonzalezblanchard.marvelheroes.ui.theme.red

@Composable
fun FullLoader(isDisplayed: Boolean) {

    if(isDisplayed){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator(
                    color = red
                )
                TitleText("Cargando contenido...")
            }

        }
    }
}