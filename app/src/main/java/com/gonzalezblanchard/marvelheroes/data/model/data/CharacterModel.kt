package com.gonzalezblanchard.marvelheroes.data.model.data

import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.google.gson.annotations.SerializedName

data class CharacterModel (
    @SerializedName("id") val id:Int = 0,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: ThumbnailModel,
    @SerializedName("resourceURI") val resourceURI: String,
)

fun CharacterItem.toModel() = CharacterModel(
    id, name, description, modified, thumbnail.toModel(), resourceURI
)
