package com.gonzalezblanchard.marvelheroes.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.usecases.characters.GetCharactersUseCase
import com.gonzalezblanchard.marvelheroes.presentation.states.CharacterUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {

    // Category state
    private val _uiState = MutableStateFlow(CharacterUIState())
    val uiState: StateFlow<CharacterUIState> = _uiState.asStateFlow()

    init {

    }

    fun retrieveCharacterList() {
        viewModelScope.launch {

            updateAppState(true, emptyList())
            val categories = getCharactersUseCase()
            updateAppState(false, categories)

        }
    }

    private fun updateAppState(isLoading:Boolean, characters:List<CharacterItem>) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = isLoading,
                charactersList = characters
            )
        }
    }


}