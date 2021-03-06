package com.canopas.campose.kotlinflow_openweather.data

import com.google.gson.annotations.SerializedName

class Main {
    @SerializedName("temp")
    var temp = 0.0

    @SerializedName("temp_min")
    var tempMin = 0.0

    @SerializedName("grnd_level")
    var grndLevel = 0.0

    @SerializedName("humidity")
    var humidity = 0

    @SerializedName("pressure")
    var pressure = 0.0

    @SerializedName("sea_level")
    var seaLevel = 0.0

    @SerializedName("temp_max")
    var tempMax = 0.0
}