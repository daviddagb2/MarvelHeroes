package com.gonzalezblanchard.marvelheroes.data.remotes.implementation

import com.gonzalezblanchard.marvelheroes.data.model.data.CharacterModel
import com.gonzalezblanchard.marvelheroes.data.remotes.interfaces.CharacterApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(
    private val api: CharacterApiClient
) {

    suspend fun getAllCategories(): List<CharacterModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCharacters()
            response.body()?.data?.results ?: emptyList()
        }
    }
}