package com.gonzalezblanchard.marvelheroes.data.remotes.interfaces

import com.gonzalezblanchard.marvelheroes.data.model.responses.RequestResponse
import retrofit2.Response
import retrofit2.http.GET


interface CharacterApiClient {

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(): Response<RequestResponse>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(): Response<RequestResponse>

}