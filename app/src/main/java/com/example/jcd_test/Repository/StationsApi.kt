package com.example.jcd_test.Repository

import com.example.jcd_test.Model.Station
import com.example.jcd_test.R
import io.reactivex.Single
import retrofit2.http.GET

interface StationsApi{
    @GET("stations?apiKey=${R.string.token_JCDecaux}")
    fun getStations(): Single<Station>
}