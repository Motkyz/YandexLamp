package com.example.lesson7.data

import android.util.Log
import com.example.lesson7.data.model.BrightnessLevelsInfo
import com.example.lesson7.data.model.ColorInfo
import javax.inject.Inject

interface LampRepository {
    //State
    suspend fun getState(): Boolean?
    suspend fun turnLampOn(): Boolean?
    suspend fun turnLampOff(): Boolean?

    //Colors
    suspend fun getColors(): List<ColorInfo>?
    suspend fun getCurrentColor(): ColorInfo?
    suspend fun setColor(colorInfo: String): Boolean?

    //Brightness
    suspend fun getBrightnessLevels(): BrightnessLevelsInfo?
    suspend fun getCurrentBrightness(): Int?
    suspend fun setBrightness(brightness: Int): Boolean?
}

class LampRepositoryImpl @Inject constructor(
    private val service: LampService
): LampRepository {
    //State
    override suspend fun getState(): Boolean? {
        return try {
            val response = service.getState()

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun turnLampOn(): Boolean? {
        return try {
            val response = service.turnLampOn()

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun turnLampOff(): Boolean? {
        return try {
            val response = service.turnLampOff()

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    //Colors
    override suspend fun getColors(): List<ColorInfo>? {
        return try {
            val response = service.loadColors()

            if (response.isSuccessful)
                 response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getCurrentColor(): ColorInfo? {
        return try {
            val response = service.loadCurrentColor()

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun setColor(colorInfo: String): Boolean? {
        return try {
            val response = service.setColor(colorInfo)

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    //Brightness
    override suspend fun getBrightnessLevels(): BrightnessLevelsInfo? {
        return try {
            val response = service.getBrightnessLevels()

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun getCurrentBrightness(): Int? {
        return try {
            val response = service.getCurrentBrightness()

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun setBrightness(brightness: Int): Boolean? {
        return try {
            val response = service.setBrightness(brightness)

            if (response.isSuccessful)
                response.body()
            else null
        } catch (e: Exception) {
            null
        }
    }
}