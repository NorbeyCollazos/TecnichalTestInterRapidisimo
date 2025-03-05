package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.roomdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LocalitiesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocalities(localities: List<LocalitiesEntity>)

    @Query("SELECT * FROM localities_table ORDER BY NombreCompleto DESC")
    fun getLocalitiesSqlite(): List<LocalitiesEntity>

    @Query("DELETE FROM localities_table")
    fun deleteLocalitiesTable()
}