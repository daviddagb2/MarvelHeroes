package com.gonzalezblanchard.marvelheroes.data.remotes.implementation

import com.gonzalezblanchard.marvelheroes.utils.Constants
import com.gonzalezblanchard.marvelheroes.utils.PreferencesManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class AuthInterceptorImpl @Inject constructor(
    private val sharedPreferences: PreferencesManager,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        try{
            val original = chain.request()
            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", Constants.APIKEY)
                .addQueryParameter("ts", Constants.TS)
                .addQueryParameter("hash", Constants.MD5)
                .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()
            return chain.proceed(request)
        }catch (ex:Exception){
            return chain.proceed(chain.request().newBuilder().build())
        }
    }

}