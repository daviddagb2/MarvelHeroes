package com.gonzalezblanchard.marvelheroes.data.remotes.interfaces

import com.gonzalezblanchard.marvelheroes.data.model.responses.RequestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiClient {

    @GET("/v1/public/characters")
    suspend fun getAllCharacters(): Response<RequestResponse>

    @GET("/v1/public/characters")
    suspend fun getAllCharactersResponse(
        @Query("offset") offset:Int,
        @Query("limit") limit:Int,
    ): Response<RequestResponse>

    @GET("/v1/public/characters/{id}")
    suspend fun getCharacter(): Response<RequestResponse>

}