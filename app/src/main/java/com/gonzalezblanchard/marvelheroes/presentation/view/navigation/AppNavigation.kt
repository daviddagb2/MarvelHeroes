package com.gonzalezblanchard.marvelheroes.presentation.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.CharacterDetailScreen
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.CharacterScreen

@Composable
fun AppNavigation(

){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.CategoryScreen.route){
        composable(route = AppScreens.CategoryScreen.route){
            CharacterScreen(navController)
        }

        composable(
            route = AppScreens.CharacterDetailScreen.route + "/{id}",
            arguments = listOf(navArgument(name = "id"){
                type = NavType.StringType
            })
        ){
            CharacterDetailScreen(navController, it.arguments?.getString("id").toString())
        }

    }
}


class Actions(navController: NavController) {
    var back: () -> Unit = {
        navController.navigateUp()
    }
    var characterDetails: (String) -> Unit = { id ->
        navController.navigate("${AppScreens.CharacterDetailScreen.route}/$id")
    }
}