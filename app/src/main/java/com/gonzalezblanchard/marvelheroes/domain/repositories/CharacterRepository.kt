package com.gonzalezblanchard.marvelheroes.domain.repositories

import com.gonzalezblanchard.marvelheroes.data.database.dao.CharacterDao
import com.gonzalezblanchard.marvelheroes.data.database.entities.toDatabase
import com.gonzalezblanchard.marvelheroes.data.remotes.implementation.CharacterService
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.responses.DataResultResponseItem
import com.gonzalezblanchard.marvelheroes.domain.models.toDomain
import javax.inject.Inject


class CharacterRepository @Inject constructor(
    private val api: CharacterService,
    private val characterDao: CharacterDao
) {

    suspend fun getCharacterResponseFromApi( offset:Int,
                                             limit:Int): DataResultResponseItem {
        val response = api.getAllCharactersFromApi(offset, limit)
        return response
    }

    /*suspend fun getAllCharactersFromDB():List<CharacterItem>{
        val response = api.getAllCharactersFromApi()
        return response.map { it.toDomain() }
    }*/

    suspend fun insertCharacters(characters:List<CharacterItem>){
        characterDao.insertAll(characters.map { it.toDatabase() })
    }

}