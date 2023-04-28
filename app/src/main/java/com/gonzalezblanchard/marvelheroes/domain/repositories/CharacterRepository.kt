package com.gonzalezblanchard.marvelheroes.domain.repositories

import com.gonzalezblanchard.marvelheroes.data.database.dao.CharacterDao
import com.gonzalezblanchard.marvelheroes.data.remotes.implementation.CharacterService
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.toDomain
import javax.inject.Inject


class CharacterRepository @Inject constructor(
    private val api: CharacterService,
    private val categoryDao: CharacterDao
) {

    suspend fun getAllCategoriesFromApi():List<CharacterItem>{
        val response = api.getAllCategories()
        return response.map { it.toDomain() }
    }

}