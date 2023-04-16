package com.example.ezysearch.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL =
    "https://www.googleapis.com"
const val KEY =
    "AIzaSyASHwIlaPXsgGiMbza7Mon2jsjAMnxZJ3I"
const val CX =
    "d7fca0ef5fc3b4834"


interface EzySearchApiService {
    @GET("customsearch/v1")
    suspend fun getSearchResult(@Query("key") key: String, @Query("cx") cx: String, @Query("q") q: String ): String
}

