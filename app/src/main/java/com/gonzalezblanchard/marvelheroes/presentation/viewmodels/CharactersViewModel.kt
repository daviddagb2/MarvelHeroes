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
    private var offset:Int = 0
    private var page:Int = 1
    private var maxpages:Int = 0
    private var counter:Int = 0
    private var limit:Int = 20
    private var total:Int = 0


    init {
        retrieveCharacterList()
    }

    fun nextPage(){
        if(page < maxpages){
            page++
            offset = page * limit
            retrieveCharacterList()
        }
        else{
            page = maxpages
            offset = page * limit
            retrieveCharacterList()
        }
    }

    fun previousPage(){
        if(page > 1){
            page--
            offset = page * limit
            retrieveCharacterList()
        }
        else{
            page = 1
            offset = 0
            retrieveCharacterList()
        }
    }

    fun retrieveCharacterList() {
        viewModelScope.launch {
            updateAppState(true, emptyList())
            val response = getCharactersUseCase(offset = offset, limit = limit)
            offset = response.offset
            counter = response.count
            total = response.total

            maxpages = total / limit
            updateAppState(false, response.results)
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