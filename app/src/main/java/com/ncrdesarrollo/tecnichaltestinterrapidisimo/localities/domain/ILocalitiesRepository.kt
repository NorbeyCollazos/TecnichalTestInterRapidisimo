package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.roomdatabase.LocalitiesEntity
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.model.LocalitieData

interface ILocalitiesRepository {

    suspend fun getListLocalities() : List<LocalitieData>

    suspend fun insertLocalities(localities: List<LocalitiesEntity>)

    suspend fun getLocalitiesDatabase(): List<LocalitieData>
}