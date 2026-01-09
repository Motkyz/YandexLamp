package com.example.lesson7.domain.stateUseCases

import com.example.lesson7.data.LampRepository
import javax.inject.Inject

interface GetStateUseCase {
    suspend operator fun invoke(): Boolean?
}

class GetStateUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetStateUseCase {
    override suspend fun invoke(): Boolean? =
        repository.getState()
}