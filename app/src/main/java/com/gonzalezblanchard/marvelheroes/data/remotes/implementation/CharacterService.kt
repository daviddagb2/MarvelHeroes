package com.gonzalezblanchard.marvelheroes.data.remotes.implementation

import com.gonzalezblanchard.marvelheroes.data.database.dao.CharacterDao
import com.gonzalezblanchard.marvelheroes.data.remotes.interfaces.CharacterApiClient
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.responses.DataResultResponseItem
import com.gonzalezblanchard.marvelheroes.domain.models.responses.toDomain
import com.gonzalezblanchard.marvelheroes.domain.models.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(
    private val api: CharacterApiClient,
    private val charactersDao: CharacterDao
) {

    suspend fun getAllCharactersFromApi(
        offset:Int,
        limit:Int
    ): DataResultResponseItem {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCharactersResponse(offset, limit)
            response.body()?.data?.toDomain() ?: DataResultResponseItem(
                0,
                0,
                0,
                0,
                emptyList()
            )

            //  .getAllCharacters()
            // response.body()?.data?.results ?: emptyList()
        }
    }

    suspend fun getAllCharactersFromDatabase(): List<CharacterItem> {
        val response = charactersDao.getAll()
        return response.map { it.toDomain() }
    }
}