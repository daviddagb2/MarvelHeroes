package com.gonzalezblanchard.marvelheroes.data.model.data

import com.gonzalezblanchard.marvelheroes.domain.models.ThumbnailItem
import com.google.gson.annotations.SerializedName

data class ThumbnailModel(
    @SerializedName("path") val path:String,
    @SerializedName("extension") val extension:String,
)

fun ThumbnailItem.toModel() = ThumbnailModel(
    path, extension
)