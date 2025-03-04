package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface LocalitiesApiServer {

    @GET("/api/localities")
    suspend fun getListLocalities(): Response<ResponseBody>
}