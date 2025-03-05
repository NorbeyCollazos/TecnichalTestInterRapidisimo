package com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.dataStorage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val PREFERENCES_NAME = "technicalTestInterRapidisimoPreferences"
private val Context.dataStore by preferencesDataStore(name = PREFERENCES_NAME)

@Module
@InstallIn(SingletonComponent::class)
abstract class PreferencesModule {

    @Binds
    @Singleton
    abstract fun providesPreferences(preferencesImpl: PreferencesImpl) : IPreferencesImpl

    companion object {
        @Provides
        @Singleton
        fun providesDataStoragePreferences(@ApplicationContext context: Context): DataStore<Preferences> {
            return context.dataStore
        }
    }

}