package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.model.UserData


interface IHomeInteractor {

    suspend fun getVersionMessage() : String

    suspend fun login() : UserData
}
