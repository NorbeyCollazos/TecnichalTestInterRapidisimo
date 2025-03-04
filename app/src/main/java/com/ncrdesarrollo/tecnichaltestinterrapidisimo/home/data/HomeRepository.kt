package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data

import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.network.model.DataLogin
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain.IHomeRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.model.UserData
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: HomeApiService) : IHomeRepository {
    override suspend fun getVersion(): Int? {

        var version: Int? = null


        runCatching { apiService.getVersion()}
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
        var userData = UserData("","","")

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
                    userData = UserData(
                        Usuario = respObj.get("Usuario").asString,
                        Identificacion = respObj.get("Identificacion").asString,
                        Nombre = respObj.get("Nombre").asString
                    )
                }
            }
            .onFailure {  Log.e("ErrorRepo", "${it.message}") }

        return userData
    }
}