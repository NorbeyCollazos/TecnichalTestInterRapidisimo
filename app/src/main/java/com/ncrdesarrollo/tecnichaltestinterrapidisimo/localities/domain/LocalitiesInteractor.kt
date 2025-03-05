package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.roomdatabase.LocalitiesEntity
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.model.LocalitieData
import javax.inject.Inject

class LocalitiesInteractor @Inject constructor(private val repository: ILocalitiesRepository) : ILocalitiesInteractor {
    override suspend fun getListLocalities(): List<LocalitieData> {

        val localities = repository.getListLocalities()
        val listLocalities = mutableListOf<LocalitiesEntity>()

        localities.forEach {
            val modelEntity = LocalitiesEntity(
                id = 0,
                AbreviacionCiudad = it.AbreviacionCiudad,
                NombreCompleto = it.NombreCompleto
            )

            listLocalities.add(modelEntity)
        }

        //repository.insertLocalities(listLocalities)

        return localities
    }
}