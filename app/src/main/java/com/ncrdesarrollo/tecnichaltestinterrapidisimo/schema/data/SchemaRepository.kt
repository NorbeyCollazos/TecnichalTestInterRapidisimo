package com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.data

import android.util.Log
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.domain.ISchemaRepository
import javax.inject.Inject

class SchemaRepository @Inject constructor(private val apiService: SchemaApiService) : ISchemaRepository{
    override suspend fun getSchema() {

        runCatching { apiService.getSchema() }
            .onSuccess {
                val responseString: String? = it.body()?.string() ?: it.errorBody()?.string()
                Log.i("responseSchema", "$responseString")
            }
            .onFailure { Log.e("ErrorRepo", "${it.message}") }
    }
}