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

    suspend fun getCharacterResponseFromApi(
        offset: Int,
        limit: Int
    ): DataResultResponseItem {
        return api.getAllCharactersFromApi(offset, limit)
    }

    suspend fun insertCharacters(characters:List<CharacterItem>){
        characterDao.insertAll(characters.map { it.toDatabase() })
    }

    suspend fun searchCharacterFromDB(searchName:String):List<CharacterItem>{
        val response = characterDao.searchCharacter(searchName)
        return response.map { it.toDomain() }
    }

    suspend fun getCharacter(characterId:Int): CharacterItem{
        val response = characterDao.getDetail(characterId = characterId).find { it.id == characterId }
        return response!!.toDomain()
    }

}