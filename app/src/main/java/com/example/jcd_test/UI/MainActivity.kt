package com.example.jcd_test.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jcd_test.R
import com.example.jcd_test.ViewModel.StationMainViewModel
import com.example.liststation.ui.adapter.StationAdapterMain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: StationMainViewModel
    private val stationsAdapter = StationAdapterMain(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(StationMainViewModel::class.java)
        viewModel.refresh()

        rc_main.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = stationsAdapter
        }
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.stations.observe(this, Observer { stations ->
            stations?.let {
                rc_main.visibility = View.VISIBLE
                stationsAdapter.updateStations(it)
            }
        })
    }
}
