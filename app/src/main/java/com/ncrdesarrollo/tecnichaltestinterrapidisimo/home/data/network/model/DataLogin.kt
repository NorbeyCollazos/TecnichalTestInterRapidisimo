package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.network.model

import com.google.gson.annotations.SerializedName

data class DataLogin(
    @SerializedName("mac")
    val mac: String,
    @SerializedName("nomAplicacion")
    val nomAplicacion: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("path")
    val path: String,
    @SerializedName("usuario")
    val usuario: String,
)
