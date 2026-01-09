package com.example.lesson7.data

import com.example.lesson7.data.model.BrightnessLevelsInfo
import com.example.lesson7.data.model.ColorInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LampService {

    @GET("/state/")
    suspend fun getState(): Response<Boolean>

    @POST("/state/on")
    suspend fun turnLampOn(): Response<Boolean>

    @POST("/state/off")
    suspend fun turnLampOff(): Response<Boolean>

    @GET("/color/")
    suspend fun loadColors(): Response<List<ColorInfo>>

    @GET("/color/current")
    suspend fun loadCurrentColor(): Response<ColorInfo>

    @POST("/color/")
    suspend fun setColor(@Query("color") colorInfo: String): Response<Boolean>

    @GET("/brightness/")
    suspend fun getBrightnessLevels(): Response<BrightnessLevelsInfo>

    @GET("/brightness/current")
    suspend fun getCurrentBrightness(): Response<Int>

    @POST("/brightness/")
    suspend fun setBrightness(@Query("level") brightness: Int): Response<Boolean>
}