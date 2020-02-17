package com.example.jcd_test.Model

import com.google.gson.annotations.SerializedName

data class Station (
    @SerializedName("contract_name")
    val city: String,
    @SerializedName("name")
    val station_name: String,
    @SerializedName("address")
    val address: String,
    @SerializedName("position")
    val position: List<Gps>,
    @SerializedName("banking")
    val banking: Boolean,
    @SerializedName("bike_stands")
    val bike_stands: Int,
    @SerializedName("available_bike_stands")
    val available_bike_stands: Int,
    @SerializedName("available_bikes")
    val available_bikes: Boolean,
    @SerializedName("status")
    val status: String
)