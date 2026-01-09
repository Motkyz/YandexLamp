package com.example.lesson7.domain.colorUseCases

import com.example.lesson7.data.LampRepository
import com.example.lesson7.data.model.ColorInfo
import javax.inject.Inject

interface GetCurrentColorUseCase {
    suspend operator fun invoke(): ColorInfo?
}

class GetCurrentColorUseCaseImpl @Inject constructor(
    private val repository: LampRepository
): GetCurrentColorUseCase {
    override suspend fun invoke(): ColorInfo? =
        repository.getCurrentColor()
}