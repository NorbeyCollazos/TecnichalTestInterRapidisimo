package com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.di

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.LocalitiesApiServer
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.LocalitiesRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.ILocalitiesInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.ILocalitiesRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.LocalitiesInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.data.SchemaApiService
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.data.SchemaRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.domain.ISchemaInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.domain.ISchemaRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.domain.SchemaInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SchemaModule {

    @Provides
    @Singleton
    fun providerSchemaApiService(retrofit: Retrofit) : SchemaApiService {
        return retrofit.create(SchemaApiService::class.java)
    }

    @Provides
    @Singleton
    fun providerSchemaRepository(apiService: SchemaApiService) : ISchemaRepository {
        return SchemaRepository(apiService)
    }

    @Provides
    @Singleton
    fun providerSchemaInteractor(repository: ISchemaRepository) : ISchemaInteractor {
        return SchemaInteractor(repository)
    }
}