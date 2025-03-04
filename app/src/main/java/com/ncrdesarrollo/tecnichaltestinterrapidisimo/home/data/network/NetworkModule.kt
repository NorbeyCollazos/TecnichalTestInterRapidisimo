package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.data.network

import android.content.Context
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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

        @Provides
        @Singleton
        fun providesRetrofit(okHttpClient: OkHttpClient) : Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(" https://testing.interrapidisimo.co:8088")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            return OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()
        }

        @Provides
        @Singleton
         fun providerHomeApiService(retrofit: Retrofit) : HomeApiService {
           return retrofit.create(HomeApiService::class.java)
         }

        @Provides
        @Singleton
        fun providerHomeRepository(apiService: HomeApiService) : IHomeRepository {
            return HomeRepository(apiService)
        }

        @Provides
        @Singleton
        fun providerHomeInteractor(repository: IHomeRepository, @ApplicationContext context: Context) : IHomeInteractor {
            return HomeInteractor(repository, context)
        }


}