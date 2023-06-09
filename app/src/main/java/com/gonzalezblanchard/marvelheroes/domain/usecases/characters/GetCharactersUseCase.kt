package com.gonzalezblanchard.marvelheroes.domain.usecases.characters


import com.gonzalezblanchard.marvelheroes.domain.models.responses.DataResultResponseItem
import com.gonzalezblanchard.marvelheroes.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(
        offset: Int,
        limit: Int
    ): DataResultResponseItem {

        var response = repository.getCharacterResponseFromApi(offset, limit)

        if(response.results.isNotEmpty()){
            repository.insertCharacters(response.results)
        }
        return response
    }

}
