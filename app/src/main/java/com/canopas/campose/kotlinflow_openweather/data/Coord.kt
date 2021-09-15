package com.canopas.campose.kotlinflow_openweather.data

import com.google.gson.annotations.SerializedName

class Coord {
    @SerializedName("lon")
    var lon = 0.0

    @SerializedName("lat")
    var lat = 0.0
}