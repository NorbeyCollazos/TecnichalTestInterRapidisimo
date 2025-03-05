package com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface SchemaApiService {

    @GET("/api/schema")
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
    suspend fun getSchema() : Response<ResponseBody>
}