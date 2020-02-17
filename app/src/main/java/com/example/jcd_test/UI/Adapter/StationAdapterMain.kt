
package com.example.liststation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jcd_test.Model.Station
import com.example.jcd_test.R
import kotlinx.android.synthetic.main.rc_main_item.view.*

class StationAdapterMain(var stations: ArrayList<Station>) :
    RecyclerView.Adapter<StationAdapterMain.StationViewHolder>() {
    fun updateStations(newStations: List<Station>) {
        stations.clear()
        stations.addAll(newStations)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = StationViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.rc_main_item, parent, false)
    )

    override fun getItemCount() = stations.size
    override fun onBindViewHolder(holder: StationViewHolder, position: Int) {
        holder.bind(stations[position])
    }

    class StationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val stationName = view.txtView_nameStation
        private val stationCity = view.txtView_city
        private val stationAdress = view.txtView_adress_station

        fun bind(stationModel: Station) {
            stationName.text = stationModel.station_name
            stationCity.text = stationModel.city
            stationAdress.text = stationModel.address

        }
    }
}