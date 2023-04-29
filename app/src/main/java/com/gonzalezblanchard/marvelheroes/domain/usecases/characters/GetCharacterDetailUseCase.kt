package com.gonzalezblanchard.marvelheroes.domain.usecases.characters

import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.repositories.CharacterRepository
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(characterId:Int): CharacterItem {
        return repository.getCharacter(characterId)
    }

}
