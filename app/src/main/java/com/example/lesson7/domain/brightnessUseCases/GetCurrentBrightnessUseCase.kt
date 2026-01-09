package com.example.lesson7.domain.brightnessUseCases

import com.example.lesson7.data.LampRepository
import javax.inject.Inject

interface GetCurrentBrightnessUseCase {
    suspend operator fun invoke(): Int?
}

class GetCurrentBrightnessUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetCurrentBrightnessUseCase {
    override suspend fun invoke(): Int? =
        repository.getCurrentBrightness()
}