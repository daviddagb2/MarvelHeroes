package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalezblanchard.marvelheroes.presentation.components.CircularIndeterminateProgressBar
@Composable
fun LoadingCharacterScreen() {
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "Cargando Categorías")
            }
        }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {
            LCBodyContent()
        }
    }
}

@Composable
fun LCBodyContent(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cargando lista de categorias")
        Spacer(Modifier.height(30.dp))
        CircularIndeterminateProgressBar(true)
    }
}

@Preview
@Composable
fun PreviewLC(){
    LoadingCharacterScreen()
}