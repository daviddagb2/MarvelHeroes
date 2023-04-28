package com.gonzalezblanchard.marvelheroes.presentation.states

import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem

data class CharacterUIState(
    val isLoading: Boolean = false,
    val charactersList : List<CharacterItem> = emptyList()

)
