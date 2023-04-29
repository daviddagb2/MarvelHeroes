package com.gonzalezblanchard.marvelheroes.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
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
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val searchCharacterUseCase: SearchCharacterUseCase
) : ViewModel() {

    // Category state
    private val _uiState = MutableStateFlow(CharacterUIState())
    val uiState: StateFlow<CharacterUIState> = _uiState.asStateFlow()
    private var _offset:Int = 0
    private var _page:Int = 1
    private var _maxpages:Int = 0
    private var _counter:Int = 0
    private var _limit:Int = 40
    private var _total:Int = 0


    //Pagination Mutable Data
    val page = MutableLiveData<Int>()
    val maxpages = MutableLiveData<Int>()

    private fun postValuePage(){
        page.postValue(_page)
        maxpages.postValue(_maxpages)
    }


    //Searchbar states
    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState


    private val _searchTextState: MutableState<String> = mutableStateOf("")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newText: String) {
        _searchTextState.value = newText
    }

    init {
        retrieveCharacterList()
    }

    fun nextPage(){
        if(_page < _maxpages){
            _page++
            _offset = _page * _limit
            retrieveCharacterList()
        }
        else{
            _page = _maxpages
            _offset = _page * _limit
            retrieveCharacterList()
        }
    }

    fun previousPage(){
        if(_page > 1){
            _page--
            _offset = _page * _limit
            retrieveCharacterList()
        }
        else{
            _page = 1
            _offset = 0
            retrieveCharacterList()
        }
    }

    fun searchLocalCharacters(searchName:String){
        viewModelScope.launch {
            updateAppState(true, emptyList())
            val response = searchCharacterUseCase(searchName)
            updateAppState(false, response)
        }
    }

    fun retrieveCharacterList() {
        viewModelScope.launch {
            updateAppState(true, emptyList())
            val response = getCharactersUseCase(offset = _offset, limit = _limit)
            _offset = response.offset
            _counter = response.count
            _total = response.total

            _maxpages = _total / _limit
            postValuePage()
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