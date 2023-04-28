package com.gonzalezblanchard.marvelheroes.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class ThumbnailEntity (
    @ColumnInfo(name = "path") val path: String,
    @ColumnInfo(name = "extension") val extension: String,
)