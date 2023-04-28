package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gonzalezblanchard.marvelheroes.presentation.components.CircularIndeterminateProgressBar
import androidx.hilt.navigation.compose.hiltViewModel
import com.gonzalezblanchard.marvelheroes.presentation.viewmodels.CharactersViewModel

@Composable
fun CharacterScreen(
    categoryViewModel: CharactersViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar() {
                Text(text = "Categorías")
            }
        }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {
            BodyContent(categoryViewModel)
        }
    }
}

@Composable
fun BodyContent(vm: CharactersViewModel){

    // State
    val appUiState by vm.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lista de categorias")
        Button(onClick = {
           // navController.navigate(route = AppScreens.SecondScreen.route + "/Este es un parametro")
            vm.retrieveCharacterList()
        }) {
            Text(text = "Obtener Categorias")
        }

        CircularIndeterminateProgressBar(appUiState.isLoading)

        ///CharacterList(!appUiState.isLoading, appUiState.charactersList)
        CharacterListGrid(!appUiState.isLoading, appUiState.charactersList)
    }
}

@Preview
@Composable
fun Preview(){
    CharacterScreen()
}