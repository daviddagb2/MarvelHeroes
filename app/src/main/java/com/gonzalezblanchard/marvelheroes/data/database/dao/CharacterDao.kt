package com.gonzalezblanchard.marvelheroes.data.database.dao

import androidx.room.*
import com.gonzalezblanchard.marvelheroes.data.database.entities.CharacterEntity

@Dao
interface CharacterDao {

    @Query("SELECT * FROM heroes_table ORDER BY id ASC")
    suspend fun getAll():List<CharacterEntity>

    @Query("SELECT * FROM heroes_table WHERE id = :characterId")
    suspend fun getDetail(characterId:Int):List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users:List<CharacterEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character:CharacterEntity)

    @Query("DELETE FROM heroes_table")
    suspend fun deleteAll()

}