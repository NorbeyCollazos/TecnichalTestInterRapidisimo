package com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.dataStorage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class PreferencesImpl @Inject constructor(private val dataStore: DataStore<Preferences>) : IPreferencesImpl {
    override suspend fun putStringDataStore(stringKey: String, value: String) {
        val key = stringPreferencesKey(stringKey)
        dataStore.edit { res ->
            res[key] = value
        }
    }

    override suspend fun getStringDataStore(stringKey: String): String? {
        val key = stringPreferencesKey(stringKey)
        val preferences = dataStore.data.first()
        return preferences[key]
    }

    override suspend fun deleteStringDataStore(stringKey: String) {
        val key = stringPreferencesKey(stringKey)
        dataStore.edit {
            it.remove(key)
        }
    }

    override suspend fun clearDataStore() {
        dataStore.edit {
            it.clear()
        }
    }
}