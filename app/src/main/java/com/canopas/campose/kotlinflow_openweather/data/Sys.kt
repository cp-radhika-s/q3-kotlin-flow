package com.canopas.campose.kotlinflow_openweather.data

import com.google.gson.annotations.SerializedName

class Sys {
    @SerializedName("country")
    var country: String? = null

    @SerializedName("sunrise")
    var sunrise = 0

    @SerializedName("sunset")
    var sunset = 0

    @SerializedName("message")
    var message = 0.0
}