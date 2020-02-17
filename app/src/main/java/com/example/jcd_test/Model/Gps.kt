package com.example.jcd_test.Model


import com.google.gson.annotations.SerializedName

data class Gps(
    @SerializedName("lat")
    val lat: Float,
    @SerializedName("lng")
    val lng: Float
)
