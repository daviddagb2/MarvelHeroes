package com.gonzalezblanchard.marvelheroes.presentation.view.navigation

sealed class AppScreens(val route:String){
    object CategoryScreen:AppScreens("category_screen")
    object CharacterDetailScreen:AppScreens("character_detail_screen")
}

