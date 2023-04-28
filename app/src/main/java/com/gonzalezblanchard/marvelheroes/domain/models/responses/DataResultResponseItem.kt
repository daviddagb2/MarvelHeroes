package com.gonzalezblanchard.marvelheroes.domain.models.responses

import com.gonzalezblanchard.marvelheroes.data.model.responses.DataResultResponse
import com.gonzalezblanchard.marvelheroes.domain.models.CharacterItem
import com.gonzalezblanchard.marvelheroes.domain.models.toDomain

data class DataResultResponseItem(
    val offset:Int = 0,
    val limit:Int = 20,
    val total:Int = 0,
    val count:Int = 0,
    val results:List<CharacterItem>,
)

fun DataResultResponse.toDomain() = DataResultResponseItem(
    offset, limit, total, count, results.map { it.toDomain() }
)