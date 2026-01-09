package com.example.lesson7.domain.colorUseCases

import com.example.lesson7.data.LampRepository
import com.example.lesson7.data.model.ColorInfo
import javax.inject.Inject

interface GetColorsUseCase {
    suspend operator fun invoke(): List<ColorInfo>?
}

class GetColorsUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetColorsUseCase {
    override suspend fun invoke(): List<ColorInfo>? =
        repository.getColors()
}