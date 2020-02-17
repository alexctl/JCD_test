package com.example.jcd_test.Repository

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApiModule {
    companion object {
        const val BASE_URL = "https://api.jcdecaux.com/vls/v1/"
    }
    //private val okHttpClient = OkHttpClient().newBuilder()
        //.build()
    @Provides
    fun provideUsersApi(): StationsApi {
        return Retrofit.Builder()
            //.client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(StationsApi::class.java)
    }

    @Provides
    fun provideUsersService(): StationsService {
        return StationsService()
    }
}