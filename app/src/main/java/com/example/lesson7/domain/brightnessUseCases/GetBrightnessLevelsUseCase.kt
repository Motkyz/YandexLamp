package com.example.lesson7.domain.brightnessUseCases

import com.example.lesson7.data.LampRepository
import com.example.lesson7.data.model.BrightnessLevelsInfo
import javax.inject.Inject

interface GetBrightnessLevelsUseCase {
    suspend operator fun invoke(): BrightnessLevelsInfo?
}

class GetBrightnessLevelsUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetBrightnessLevelsUseCase {
    override suspend fun invoke(): BrightnessLevelsInfo? =
        repository.getBrightnessLevels()
}