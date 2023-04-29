package com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.gonzalezblanchard.marvelheroes.presentation.components.appbars.MainAppBar
import com.gonzalezblanchard.marvelheroes.presentation.states.SearchWidgetState
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.sections.BodyListContent
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.sections.SearchListContent
import com.gonzalezblanchard.marvelheroes.presentation.viewmodels.CharactersViewModel

@Composable
fun CharacterScreen(
    navController: NavController,
    characterVM: CharactersViewModel = hiltViewModel()
) {

    val searchWidgetState by characterVM.searchWidgetState
    val searchTextState by characterVM.searchTextState
    val mContext = LocalContext.current

    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    characterVM.updateSearchTextState(newText = it)
                },
                onCloseClicked = {
                    characterVM.updateSearchTextState(newText = "")
                    characterVM.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    Log.d("Searched Text", it)
                    Toast.makeText(mContext, it, Toast.LENGTH_SHORT).show()
                    characterVM.searchLocalCharacters(it)
                },
                onSearchTriggered = {
                    characterVM.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
                }
            )
        }
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding)) {


            when(searchWidgetState){
                SearchWidgetState.CLOSED -> {
                    BodyListContent(characterVM, navController)
                }

                SearchWidgetState.OPENED -> {
                    SearchListContent(characterVM, navController)
                }
            }

        }
    }
}

