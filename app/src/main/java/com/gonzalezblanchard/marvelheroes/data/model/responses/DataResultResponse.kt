package com.gonzalezblanchard.marvelheroes.data.model.responses

import com.gonzalezblanchard.marvelheroes.data.model.data.CharacterModel
import com.google.gson.annotations.SerializedName

data class DataResultResponse(
    @SerializedName("offset") val offset:Int = 0,
    @SerializedName("limit") val limit:Int = 20,
    @SerializedName("total") val total:Int = 0,
    @SerializedName("count") val count:Int = 0,
    @SerializedName("results") val results:List<CharacterModel>,
)
