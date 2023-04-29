package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.sections

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gonzalezblanchard.marvelheroes.presentation.components.CircularIndeterminateProgressBar
import com.gonzalezblanchard.marvelheroes.presentation.components.TitleText
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.CharacterListGrid
import com.gonzalezblanchard.marvelheroes.presentation.viewmodels.CharactersViewModel
import com.gonzalezblanchard.marvelheroes.ui.theme.red

@Composable
fun BodyListContent(vm: CharactersViewModel,
                    navController: NavController
){

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

            Button(onClick = {
                vm.previousPage()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = red)) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    modifier = Modifier.size(20.dp),
                    contentDescription = "drawable icons",
                    tint = Color.White
                )
            } //End Button

            TitleText(value = "Personajes de Marvel")

            Button(onClick = {
                vm.nextPage()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = red)) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    modifier = Modifier.size(20.dp),
                    contentDescription = "drawable icons",
                    tint = Color.White
                )
            } //End Button

        }

        CircularIndeterminateProgressBar(appUiState.isLoading)

        CharacterListGrid(!appUiState.isLoading, appUiState.charactersList, navController)
    }
}

