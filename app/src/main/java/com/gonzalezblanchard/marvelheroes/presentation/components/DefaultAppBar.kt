package com.gonzalezblanchard.marvelheroes.presentation.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun DefaultAppBar(onSearchClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(
                text = "Marvel Heroes"
            )
        },
        actions = {
            IconButton(
                onClick = {{ onSearchClicked() }}
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
        }
    )
    
}