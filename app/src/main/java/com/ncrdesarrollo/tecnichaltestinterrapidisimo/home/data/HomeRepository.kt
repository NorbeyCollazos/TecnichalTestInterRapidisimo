package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data

import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.Utils.ArgsNames
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.dataStorage.IPreferencesImpl
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.network.model.DataLogin
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain.IHomeRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.model.UserData
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiService: HomeApiService,
    private val preferences: IPreferencesImpl
) : IHomeRepository {
    override suspend fun getVersion(): Int? {

        var version: Int? = null


        runCatching { apiService.getVersion() }
            .onSuccess {
                val responseString: String? = it.body()?.string() ?: it.errorBody()?.string()
                if (responseString != null) {
                    version = responseString.toInt()
                }
            }
            .onFailure { Log.e("ErrorRepo", "${it.message}") }

        return version
    }

    override suspend fun login(): UserData {
        var userData = UserData("", "", "")

        val dataLogin = DataLogin(
            mac = "",
            nomAplicacion = "Controller APP",
            password = "SW50ZXIyMDIx\n",
            path = "",
            usuario = "cGFtLm1lcmVkeTIx\n"
        )

        runCatching { apiService.login(data = dataLogin) }
            .onSuccess {
                val responseString: String? = it.body()?.string() ?: it.errorBody()?.string()
                if (responseString != null) {
                    val respObj: JsonObject = JsonParser().parse(responseString).asJsonObject
                    preferences.putStringDataStore(ArgsNames.USUARIO, respObj.get("Usuario").asString)
                    preferences.putStringDataStore(ArgsNames.IDENTIFICACION, respObj.get("Identificacion").asString)
                    preferences.putStringDataStore(ArgsNames.NOMBRE, respObj.get("Nombre").asString)

                    userData = UserData(
                        Usuario = preferences.getStringDataStore(ArgsNames.USUARIO).toString(),
                        Identificacion = preferences.getStringDataStore(ArgsNames.IDENTIFICACION).toString(),
                        Nombre = preferences.getStringDataStore(ArgsNames.NOMBRE).toString()
                    )

                }
            }
            .onFailure { Log.e("ErrorRepo", "${it.message}") }

        return userData
    }
}