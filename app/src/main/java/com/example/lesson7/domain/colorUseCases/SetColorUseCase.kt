package com.example.lesson7.domain.colorUseCases

import com.example.lesson7.data.LampRepository
import javax.inject.Inject

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Boolean?
}

class SetColorUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): SetColorUseCase {
    override suspend fun invoke(color: String): Boolean? =
        repository.setColor(color)
}