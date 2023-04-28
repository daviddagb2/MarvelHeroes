package com.gonzalezblanchard.marvelheroes.di

import android.content.Context
import androidx.room.Room
import com.gonzalezblanchard.marvelheroes.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    private val DGAPP_DATABASE_NAME = "MarvelHeroesDB"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DGAPP_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase) = db.getCharacterDao()
}