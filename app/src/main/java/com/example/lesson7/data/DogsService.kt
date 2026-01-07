package com.example.lesson7.data

import com.example.lesson7.data.model.DogInfo
import retrofit2.Response
import retrofit2.http.GET

interface DogsService {

    @GET("woof.json")
    suspend fun loadDogInfo(): Response<DogInfo>
}