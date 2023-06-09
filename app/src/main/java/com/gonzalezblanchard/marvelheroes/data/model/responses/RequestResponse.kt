package com.gonzalezblanchard.marvelheroes.data.model.responses

import com.google.gson.annotations.SerializedName
data class RequestResponse(
    @SerializedName("code") val code:Int = 200,
    @SerializedName("status") val status:String = "",
    @SerializedName("copyright") val copyright:String = "",
    @SerializedName("attributionText") val attributionText:String = "",
    @SerializedName("attributionHTML") val attributionHTML:String = "",
    @SerializedName("etag") val etag:String = "",
    @SerializedName("data") val data:DataResultResponse,
)
