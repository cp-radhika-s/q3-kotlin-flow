package com.canopas.campose.kotlinflow_openweather.data

import com.google.gson.annotations.SerializedName

class Wind {
    @SerializedName("deg")
    var deg = 0.0

    @SerializedName("speed")
    var speed = 0.0
}