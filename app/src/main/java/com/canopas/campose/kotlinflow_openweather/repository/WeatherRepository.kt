package com.canopas.campose.kotlinflow_openweather.repository

import com.canopas.campose.kotlinflow_openweather.Constant
import com.canopas.campose.kotlinflow_openweather.api.ApiService
import com.canopas.campose.kotlinflow_openweather.data.CurrentWeatherResponse
import com.canopas.campose.kotlinflow_openweather.data.fivedayweather.FiveDayResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepository @Inject constructor(val service: ApiService) {

    fun getCurrentWeather(query:String):Flow<CurrentWeatherResponse>{
        return  flow {
            val response = service.getCurrentWeather(query,Constant.APP_ID)
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    fun getFiveDaysHourlyWeather(query: String):Flow<FiveDayResponse>{
        return  flow {
            val response = service.getFiveDaysWeather(query,Constant.APP_ID)
            emit(response)
        }.flowOn(Dispatchers.IO)
    }


}