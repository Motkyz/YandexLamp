package com.example.lesson7.data

import com.example.lesson7.data.model.DogInfo
import javax.inject.Inject

interface DogsRepository {
    suspend fun getDog(): DogInfo?
}

class DogRepositoryImp @Inject constructor(
    private val service: DogsService
): DogsRepository {
    override suspend fun getDog(): DogInfo? {
        val response = service.loadDogInfo()

        return if (response.isSuccessful)
            response.body()
        else null
    }

}