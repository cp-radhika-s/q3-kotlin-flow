package com.canopas.campose.kotlinflow_openweather.data.fivedayweather

import com.google.gson.annotations.SerializedName
import com.canopas.campose.kotlinflow_openweather.data.WeatherItem
import com.canopas.campose.kotlinflow_openweather.data.Clouds
import com.canopas.campose.kotlinflow_openweather.data.Wind
import com.canopas.campose.kotlinflow_openweather.data.fivedayweather.Rain

class ItemHourly {
    @SerializedName("dt")
    var dt = 0

    @SerializedName("dt_txt")
    var dtTxt: String? = null

    @SerializedName("weather")
    var weather: List<WeatherItem>? = null

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("wind")
    var wind: Wind? = null

    @SerializedName("rain")
    var rain: Rain? = null


}