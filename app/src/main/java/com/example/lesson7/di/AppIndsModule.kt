package com.example.lesson7.di

import com.example.lesson7.data.DogRepositoryImp
import com.example.lesson7.data.DogsRepository
import com.example.lesson7.domain.GetDogsUseCase
import com.example.lesson7.domain.GetDogsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindDogsRepository(impl: DogRepositoryImp): DogsRepository

    @Binds
    fun bindGetDogsUseCase(
        impl: GetDogsUseCaseImpl
    ): GetDogsUseCase
}