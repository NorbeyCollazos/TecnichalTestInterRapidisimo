package com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.dataStorage

interface IPreferencesImpl {

    suspend fun putStringDataStore(stringKey: String, value: String)

    suspend fun getStringDataStore(stringKey: String): String?

    suspend fun deleteStringDataStore(stringKey: String)

    suspend fun clearDataStore()

}