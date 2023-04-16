package com.example.ezysearch.network.Module

import com.example.ezysearch.network.BASE_URL
import com.example.ezysearch.network.EzySearchApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EzySearchModule {
    @Singleton
    @Provides
    fun provideRetrofitService(): EzySearchApiService {
        return Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(EzySearchApiService::class.java)
    }
}