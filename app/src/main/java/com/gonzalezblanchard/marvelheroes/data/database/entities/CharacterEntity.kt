package com.gonzalezblanchard.marvelheroes.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gonzalezblanchard.marvelheroes.data.database.entities.ThumbnailEntity

@Entity(tableName = "heroes_table")
data class CharacterEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "modified") val modified: String,
    @Embedded val thumbnail: ThumbnailEntity?,
    @ColumnInfo(name = "resource_uri") val resourceURI: String,
)