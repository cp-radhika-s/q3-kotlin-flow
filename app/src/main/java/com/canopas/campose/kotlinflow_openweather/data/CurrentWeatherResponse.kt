package com.canopas.campose.kotlinflow_openweather.data

import com.google.gson.annotations.SerializedName

class CurrentWeatherResponse {
    @SerializedName("dt")
    var dt = 0

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("weather")
    var weather: List<WeatherItem>? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("cod")
    var cod = 0

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("id")
    var id = 0

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("base")
    var base: String? = null

    @SerializedName("wind")
    var wind: Wind? = null


    fun getTemp() = main?.temp ?: 0.0
    fun getHumidity() = main?.humidity ?: 0
    fun getDescription() = weather?.get(0)?.description ?: ""
    fun getMain() = weather?.get(0)?.main ?: ""
    fun getWeatherId() = weather?.get(0)?.id ?: 0
    fun getWindDeg()= wind?.deg?:0.0
    fun getWindSpeed()= wind?.speed?:0.0
}