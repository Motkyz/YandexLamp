package com.example.lesson7.domain

import com.example.lesson7.data.DogsRepository
import com.example.lesson7.data.model.DogInfo
import javax.inject.Inject

interface GetDogsUseCase {
   suspend operator fun invoke(): DogInfo?
}

class GetDogsUseCaseImpl @Inject constructor(
    private val repository: DogsRepository
): GetDogsUseCase {
    override suspend fun invoke(): DogInfo? =
        repository.getDog()
}

