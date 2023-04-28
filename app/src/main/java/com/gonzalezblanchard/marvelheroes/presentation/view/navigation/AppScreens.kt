package com.gonzalezblanchard.marvelheroes.presentation.view.navigation

sealed class AppScreens(val route:String){
    object CategoryScreen:AppScreens("category_screen")
    //object SecondScreen:AppScreens("second_screen")
}

