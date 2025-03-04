package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.model.LocalitieData
import javax.inject.Inject

class LocalitiesInteractor @Inject constructor(private val repository: ILocalitiesRepository) : ILocalitiesInteractor {
    override suspend fun getListLocalities(): List<LocalitieData> {
        return repository.getListLocalities()
    }
}