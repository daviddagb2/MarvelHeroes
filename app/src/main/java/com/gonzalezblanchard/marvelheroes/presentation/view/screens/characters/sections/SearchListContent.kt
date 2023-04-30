package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.gonzalezblanchard.marvelheroes.presentation.viewmodels.CharactersViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gonzalezblanchard.marvelheroes.presentation.components.CharacterNotFound
import com.gonzalezblanchard.marvelheroes.presentation.components.CircularIndeterminateProgressBar
import com.gonzalezblanchard.marvelheroes.presentation.components.TitleText
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.CharacterListGrid

@Composable
fun SearchListContent(vm: CharactersViewModel, navController: NavController){

    // State
    val appUiState by vm.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center) {

            TitleText(value = "Búsqueda de Personajes")

        }

        CircularIndeterminateProgressBar(appUiState.isLoading)

        if(!appUiState.charactersList.isEmpty() && !appUiState.isLoading){
            CharacterListGrid(!appUiState.isLoading, appUiState.charactersList, navController)
        }

        if(appUiState.charactersList.isEmpty() && !appUiState.isLoading){
            CharacterNotFound()
        }

    }
}

