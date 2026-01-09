package com.example.lesson7.domain.brightnessUseCases

import com.example.lesson7.data.LampRepository
import javax.inject.Inject

interface SetBrightnessUseCase {
    suspend operator fun invoke(brightness: Int): Boolean?
}

class SetBrightnessUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): SetBrightnessUseCase {
    override suspend fun invoke(brightness: Int): Boolean? =
        repository.setBrightness(brightness)
}