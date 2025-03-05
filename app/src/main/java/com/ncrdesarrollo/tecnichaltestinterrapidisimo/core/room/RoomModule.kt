package com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val TEST_DATABASE_NAME = "test_database_name"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TestInterDatabase::class.java, TEST_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideLocalitiesDao(db: TestInterDatabase) = db.getLocalitiesDao()
}