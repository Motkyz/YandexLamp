package com.example.lesson7.di

import com.example.lesson7.BuildConfig
import com.example.lesson7.data.LampService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
object NetworkModule {

    @Provides
    fun provideLampService(): LampService = Retrofit.Builder()
        .baseUrl(BuildConfig.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}
