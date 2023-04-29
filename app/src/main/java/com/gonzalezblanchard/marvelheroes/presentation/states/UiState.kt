package com.gonzalezblanchard.marvelheroes.presentation.states

sealed class UiState {
    object StartedUI : UiState()
    object InProgress : UiState()
    object Complete : UiState()
    object Error : UiState()
}