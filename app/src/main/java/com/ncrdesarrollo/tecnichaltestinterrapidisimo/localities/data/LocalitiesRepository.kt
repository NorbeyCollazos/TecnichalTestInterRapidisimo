package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data

import android.util.Log
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.ILocalitiesRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.model.LocalitieData
import org.json.JSONArray
import javax.inject.Inject

class LocalitiesRepository @Inject constructor(private val apiServer: LocalitiesApiServer) : ILocalitiesRepository {
    override suspend fun getListLocalities(): List<LocalitieData> {

        val listLocalities: MutableList<LocalitieData> = mutableListOf()

        runCatching { apiServer.getListLocalities() }
            .onSuccess {
                val responseString: String? = it.body()?.string() ?: it.errorBody()?.string()
                val jsonArray = JSONArray(responseString)
                for (i in 0  until  jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val model = LocalitieData(
                        AbreviacionCiudad = jsonObject.getString("AbreviacionCiudad").toString(),
                        NombreCompleto = jsonObject.getString("NombreCompleto").toString()
                    )
                    listLocalities.add(model)
                }
            }
            .onFailure { Log.e("ErrorRepo", "${it.message}") }

        return listLocalities
    }
}