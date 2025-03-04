package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.model.UserData


interface IHomeRepository {

    suspend fun getVersion() : Int?

    suspend fun login() : UserData
}