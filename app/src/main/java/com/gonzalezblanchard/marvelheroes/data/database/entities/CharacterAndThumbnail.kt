package com.gonzalezblanchard.marvelheroes.data.database.entities

import androidx.room.Embedded
import androidx.room.Relation

data class CharacterAndThumbnail(
    @Embedded val character: CharacterEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "character_owner_id"
    )
    val thumbnail: ThumbnailEntity
)
