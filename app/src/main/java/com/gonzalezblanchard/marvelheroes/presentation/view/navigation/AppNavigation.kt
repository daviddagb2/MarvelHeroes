package com.gonzalezblanchard.marvelheroes.presentation.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gonzalezblanchard.marvelheroes.presentation.view.screens.characters.CharacterScreen

@Composable
fun AppNavigation(

){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.CategoryScreen.route){
        composable(route = AppScreens.CategoryScreen.route){
            CharacterScreen()
        }

        /*composable(
            route = AppScreens.SecondScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text"){
                type = NavType.StringType
            })
        ){
            SecondScreen(navController, it.arguments?.getString("text"))
        }*/

    }
}


class Actions(navController: NavHostController) {
    var back: () -> Unit = {
        navController.navigateUp()
    }
    var actionDetails: (String) -> Unit = { movieId ->
        ///navController.navigate("${Routes.Details.route}/$movieId")
    }
}