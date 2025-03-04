package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data


import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.network.model.DataLogin
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface HomeApiService {

    @GET("/api/version")
    suspend fun getVersion(): Response<ResponseBody>

    @POST("/auth")
    @Headers(
        "Usuario:pam.meredy21",
        "Identificacion:987204545",
        "Accept:text/json",
        "IdUsuario:pam.meredy21",
        "IdCentroServicio:1295",
        "NombreCentroServicio:PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA30#7-45",
        "IdAplicativoOrigen:9",
        "Content-Type:application/json"
    )
    suspend fun login(@Body data: DataLogin): Response<ResponseBody>
}