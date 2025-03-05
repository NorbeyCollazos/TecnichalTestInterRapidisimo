package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.network

import android.content.Context
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.dataStorage.IPreferencesImpl
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.HomeApiService
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.HomeRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain.HomeInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain.IHomeInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain.IHomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

        @Provides
        @Singleton
         fun providerHomeApiService(retrofit: Retrofit) : HomeApiService {
           return retrofit.create(HomeApiService::class.java)
         }

        @Provides
        @Singleton
        fun providerHomeRepository(apiService: HomeApiService, preferencesImpl: IPreferencesImpl) : IHomeRepository {
            return HomeRepository(apiService, preferencesImpl)
        }

        @Provides
        @Singleton
        fun providerHomeInteractor(repository: IHomeRepository, @ApplicationContext context: Context) : IHomeInteractor {
            return HomeInteractor(repository, context)
        }


}