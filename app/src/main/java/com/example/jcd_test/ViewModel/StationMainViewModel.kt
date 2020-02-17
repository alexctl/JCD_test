package com.example.jcd_test.ViewModel

import com.example.jcd_test.Model.Station
import com.example.jcd_test.Repository.StationsService

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jcd_test.Repository.DaggerApiComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StationMainViewModel : ViewModel() {
    @Inject
    lateinit var stationsService: StationsService


    init {
        DaggerApiComponent.create().inject(this)
    }

    private val disposable = CompositeDisposable()
    val stations = MutableLiveData<List<Station>>()
    fun refresh() {
        fetchStations()
    }

    private fun fetchStations() {
        disposable.add(
            stationsService.getStations()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Station>() {
                    override fun onSuccess(data: Station) {
                        Log.d("error ", "" + data)
                        val listStation : MutableList<Station> = ArrayList()
                        listStation.add(Station(data.city, data.station_name, data.address,
                            data.position, data.banking, data.bike_stands,data.available_bike_stands,
                            data.available_bikes, data.status))

                        stations.value = listStation
                    }

                    override fun onError(e: Throwable) {
                        Log.d("error ", "" + e.printStackTrace())
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}