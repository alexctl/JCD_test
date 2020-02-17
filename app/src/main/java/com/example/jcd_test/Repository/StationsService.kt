package com.example.jcd_test.Repository

import com.example.jcd_test.Model.Station
import io.reactivex.Single
import javax.inject.Inject

class StationsService{

    @Inject
    lateinit var api : StationsApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getStations(): Single<Station>{
        return api.getStations()
    }
}