package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.di

import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.LocalitiesApiServer
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.data.LocalitiesRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.ILocalitiesInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.ILocalitiesRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.LocalitiesInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalitiesModule {

    @Provides
    @Singleton
    fun providerLocalitiesApiService(retrofit: Retrofit) : LocalitiesApiServer {
        return retrofit.create(LocalitiesApiServer::class.java)
    }

    @Provides
    @Singleton
    fun providerLocalitiesRepository(apiService: LocalitiesApiServer) : ILocalitiesRepository {
        return LocalitiesRepository(apiService)
    }

    @Provides
    @Singleton
    fun providerLocalitiesInteractor(repository: ILocalitiesRepository) : ILocalitiesInteractor {
        return LocalitiesInteractor(repository)
    }
}