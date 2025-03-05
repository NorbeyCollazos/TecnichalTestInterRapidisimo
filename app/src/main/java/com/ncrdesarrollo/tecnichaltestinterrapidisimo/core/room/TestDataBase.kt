package com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.roomdatabase.LocalitiesDao
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.roomdatabase.LocalitiesEntity


@Database(
    entities = [LocalitiesEntity::class],
    version = 1
)
abstract class TestInterDatabase : RoomDatabase() {
    abstract fun getLocalitiesDao(): LocalitiesDao
}