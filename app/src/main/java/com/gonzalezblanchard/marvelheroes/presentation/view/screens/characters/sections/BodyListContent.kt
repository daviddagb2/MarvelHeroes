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
import com.gonzalezblanchard.marvelheroes.presentation.components.SimplePaginator
import com.gonzalezblanchard.marvelheroes.presentation.components.SimplePaginatorHeader
import com.gonzalezblanchard.marvelheroes.presentation.components.TitleText
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.CharacterListGrid
import com.gonzalezblanchard.marvelheroes.presentation.viewmodels.CharactersViewModel
import com.gonzalezblanchard.marvelheroes.ui.theme.red

@Composable
fun BodyListContent(vm: CharactersViewModel,
                    navController: NavController,
                    page:Int,
                    maxpages:Int
){

    // State
    val appUiState by vm.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        CircularIndeterminateProgressBar(appUiState.isLoading)

        if(!appUiState.isLoading){
            SimplePaginatorHeader(
                currentPage = page,
                maxPages = maxpages,
                onNextPage = {
                    vm.nextPage()
                },
                onPreviousPage = {
                    vm.previousPage()
                },
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 65.dp)
                    .padding(top = 20.dp)
                ,
                contentAlignment = Alignment.Center
            ) {
                CharacterListGrid(
                    !appUiState.isLoading,
                    appUiState.charactersList,
                    navController,
                )

            }

            Box(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.BottomCenter)

            ) {
                SimplePaginator(
                    showHeader = false,
                    currentPage = page,
                    maxPages = maxpages,
                    onNextPage = {
                        vm.nextPage()
                    },
                    onPreviousPage = {
                        vm.previousPage()
                    },
                    onGoToPage = {
                        vm.goToPage(it)
                    },
                )
            }
        }




    }
}

