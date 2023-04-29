package com.gonzalezblanchard.marvelheroes.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.ThumbnailItem
import com.gonzalezblanchard.marvelheroes.domain.usecases.characters.GetCharacterDetailUseCase
import com.gonzalezblanchard.marvelheroes.domain.usecases.characters.GetCharactersUseCase
import com.gonzalezblanchard.marvelheroes.domain.usecases.characters.SearchCharacterUseCase
import com.gonzalezblanchard.marvelheroes.presentation.states.CharacterUIState
import com.gonzalezblanchard.marvelheroes.presentation.states.SearchWidgetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
) : ViewModel() {

    // Category state
    val isLoading = MutableLiveData<Boolean>()

    var _characterItem = MutableLiveData<CharacterItem>()
    val characterItemState: MutableLiveData<CharacterItem> = _characterItem

    init {
        //retrieveCharacterList()
    }

    fun getCharacterDetail(characterId:Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val ticket = getCharacterDetailUseCase(characterId)
            isLoading.postValue(false)
            _characterItem.postValue(ticket)
        }
    }


}