package com.canopas.campose.kotlinflow_openweather.api

import com.canopas.campose.kotlinflow_openweather.data.CurrentWeatherResponse
import com.canopas.campose.kotlinflow_openweather.data.fivedayweather.FiveDayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather?units=metric&lang=en")
    suspend fun getCurrentWeather(
        @Query("q") q: String?,
        @Query("appid") appId: String?
    ): CurrentWeatherResponse

    @GET("forecast?units=metric&lang=en")
   suspend fun getFiveDaysWeather(
        @Query("q") q: String?,
        @Query("appid") appId: String
    ): FiveDayResponse
}