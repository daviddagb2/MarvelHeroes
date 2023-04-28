package com.gonzalezblanchard.marvelheroes.domain.models

import com.gonzalezblanchard.marvelheroes.data.database.entities.ThumbnailEntity
import com.gonzalezblanchard.marvelheroes.data.model.data.ThumbnailModel

data class ThumbnailItem (
    val path: String,
    val extension: String,
)

fun ThumbnailModel.toDomain() = ThumbnailItem(
    path, extension
)

fun ThumbnailEntity.toDomain() = ThumbnailItem(
    path, extension
)
