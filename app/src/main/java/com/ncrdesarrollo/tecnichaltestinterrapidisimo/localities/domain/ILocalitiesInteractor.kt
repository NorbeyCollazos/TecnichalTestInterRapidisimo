package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.model.LocalitieData

interface ILocalitiesInteractor {

    suspend fun getListLocalities() : List<LocalitieData>
}