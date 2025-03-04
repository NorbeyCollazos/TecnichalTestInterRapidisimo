package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.model.LocalitieData

interface ILocalitiesRepository {

    suspend fun getListLocalities() : List<LocalitieData>
}