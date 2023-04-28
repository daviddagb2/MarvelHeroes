package com.gonzalezblanchard.marvelheroes.domain.models

import com.gonzalezblanchard.marvelheroes.data.model.data.CharacterModel
import com.gonzalezblanchard.marvelheroes.data.database.entities.CharacterEntity

data class CharacterItem (
    val id:Int = 0,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: ThumbnailItem,
    val resourceURI: String,
)


fun CharacterModel.toDomain() = CharacterItem(
    id, name, description, modified, thumbnail.toDomain(), resourceURI
)

fun CharacterEntity.toDomain() = thumbnail?.let {
    CharacterItem(
        id, name, description, modified, it.toDomain(), resourceURI
    )
}
