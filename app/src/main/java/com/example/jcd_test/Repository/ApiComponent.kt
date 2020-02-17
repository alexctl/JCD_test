package com.example.jcd_test.Repository

import com.example.jcd_test.ViewModel.StationMainViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: StationsService)
    fun inject(viewModel: StationMainViewModel)
}