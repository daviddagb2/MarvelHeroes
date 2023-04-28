package com.gonzalezblanchard.marvelheroes.di

import android.content.Context
import com.gonzalezblanchard.marvelheroes.data.remotes.interfaces.CharacterApiClient
import com.gonzalezblanchard.marvelheroes.utils.PreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.gonzalezblanchard.marvelheroes.data.remotes.implementation.AuthInterceptorImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.DateFormat
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.gonzalezblanchard.marvelheroes.utils.BooleanObjectTypeAdapter
import com.gonzalezblanchard.marvelheroes.utils.BooleanPrimitiveTypeAdapter
import com.gonzalezblanchard.marvelheroes.utils.Constants

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): PreferencesManager {
        return PreferencesManager(context)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        authInterceptor: AuthInterceptorImpl
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()


    @Singleton
    @Provides
    fun provideAuthInterceptorImpl(sharedPreferences: PreferencesManager):
            AuthInterceptorImpl = AuthInterceptorImpl(sharedPreferences)

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{

        val gson: Gson = GsonBuilder()
            .enableComplexMapKeySerialization()
            .serializeNulls()
            .setDateFormat(DateFormat.LONG)
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .setVersion(1.0)
            .registerTypeAdapter(Boolean::class.javaObjectType, BooleanObjectTypeAdapter())
            .registerTypeAdapter(Boolean::class.javaPrimitiveType, BooleanPrimitiveTypeAdapter())
            .create()

        return  Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun providesCharacterApiClient(retrofit: Retrofit): CharacterApiClient {
        return retrofit.create(CharacterApiClient::class.java)
    }


}