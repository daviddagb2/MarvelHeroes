package com.gonzalezblanchard.marvelheroes.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gonzalezblanchard.marvelheroes.data.database.dao.CharacterDao
import com.gonzalezblanchard.marvelheroes.data.database.entities.CharacterEntity

@Database(entities = [
    CharacterEntity::class,
], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getCharacterDao():CharacterDao

}