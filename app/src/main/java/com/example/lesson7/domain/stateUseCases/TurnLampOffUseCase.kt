package com.example.lesson7.domain.stateUseCases

import com.example.lesson7.data.LampRepository
import javax.inject.Inject

interface ToggleLampUseCase {
    suspend operator fun invoke(): Boolean?
}

class ToggleLampUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): ToggleLampUseCase {
    override suspend fun invoke(): Boolean? =
        repository.turnLampOff()
}