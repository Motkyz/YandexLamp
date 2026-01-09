package com.example.lesson7.domain.stateUseCases

import com.example.lesson7.data.LampRepository
import javax.inject.Inject

interface TurnLampOnUseCase {
    suspend operator fun invoke(): Boolean?
}

class TurnLampOnUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): TurnLampOnUseCase {
    override suspend fun invoke(): Boolean? =
        repository.turnLampOn()
}