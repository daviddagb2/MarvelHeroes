package com.gonzalezblanchard.marvelheroes.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gonzalezblanchard.marvelheroes.data.database.entities.ThumbnailEntity
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem

@Entity(tableName = "heroes_table")
data class CharacterEntity (
    @PrimaryKey
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "modified") val modified: String,
    @Embedded val thumbnail: ThumbnailEntity?,
    @ColumnInfo(name = "resource_uri") val resourceURI: String,
)

fun CharacterItem.toDatabase() = CharacterEntity(
    id = id,
    name = name,
    description = description,
    modified = modified,
    thumbnail = thumbnail.toDatabase(),
    resourceURI = resourceURI
)
