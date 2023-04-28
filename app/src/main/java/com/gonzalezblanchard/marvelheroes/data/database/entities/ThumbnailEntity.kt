package com.gonzalezblanchard.marvelheroes.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gonzalezblanchard.marvelheroes.data.model.data.ThumbnailModel
import com.gonzalezblanchard.marvelheroes.domain.models.ThumbnailItem

data class ThumbnailEntity (
    @ColumnInfo(name = "path") val path: String,
    @ColumnInfo(name = "extension") val extension: String,
)

fun ThumbnailItem.toDatabase() = ThumbnailEntity(
    path, extension
)