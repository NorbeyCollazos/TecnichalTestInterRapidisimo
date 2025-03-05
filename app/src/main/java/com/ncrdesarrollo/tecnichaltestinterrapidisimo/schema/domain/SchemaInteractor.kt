package com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.domain

import javax.inject.Inject

class SchemaInteractor @Inject constructor(private val repository: ISchemaRepository) : ISchemaInteractor {
    override suspend fun getSchema() {
        repository.getSchema()
    }
}