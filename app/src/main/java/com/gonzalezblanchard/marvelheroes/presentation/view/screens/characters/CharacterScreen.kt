package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalezblanchard.marvelheroes.presentation.components.CircularIndeterminateProgressBar
import androidx.hilt.navigation.compose.hiltViewModel
import com.gonzalezblanchard.marvelheroes.presentation.components.TitleText
import com.gonzalezblanchard.marvelheroes.presentation.viewmodels.CharactersViewModel
import com.gonzalezblanchard.marvelheroes.ui.theme.red

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

        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
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


       /* Button(onClick = {
           // navController.navigate(route = AppScreens.SecondScreen.route + "/Este es un parametro")
            vm.retrieveCharacterList()
        }) {
            Text(text = "Obtener personajes")
        }*/

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