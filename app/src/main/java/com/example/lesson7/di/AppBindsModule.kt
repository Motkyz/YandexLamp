package com.example.lesson7.di

import com.example.lesson7.data.LampRepository
import com.example.lesson7.data.LampRepositoryImpl
import com.example.lesson7.domain.brightnessUseCases.GetBrightnessLevelsUseCase
import com.example.lesson7.domain.brightnessUseCases.GetBrightnessLevelsUseCaseImpl
import com.example.lesson7.domain.colorUseCases.GetColorsUseCase
import com.example.lesson7.domain.colorUseCases.GetColorsUseCaseImpl
import com.example.lesson7.domain.brightnessUseCases.GetCurrentBrightnessUseCase
import com.example.lesson7.domain.brightnessUseCases.GetCurrentBrightnessUseCaseImpl
import com.example.lesson7.domain.colorUseCases.GetCurrentColorUseCase
import com.example.lesson7.domain.colorUseCases.GetCurrentColorUseCaseImpl
import com.example.lesson7.domain.stateUseCases.GetStateUseCase
import com.example.lesson7.domain.stateUseCases.GetStateUseCaseImpl
import com.example.lesson7.domain.brightnessUseCases.SetBrightnessUseCase
import com.example.lesson7.domain.brightnessUseCases.SetBrightnessUseCaseImpl
import com.example.lesson7.domain.colorUseCases.SetColorUseCase
import com.example.lesson7.domain.colorUseCases.SetColorUseCaseImpl
import com.example.lesson7.domain.stateUseCases.ToggleLampUseCase
import com.example.lesson7.domain.stateUseCases.ToggleLampUseCaseImpl
import com.example.lesson7.domain.stateUseCases.TurnLampOnUseCase
import com.example.lesson7.domain.stateUseCases.TurnLampOnUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindLampRepository(impl: LampRepositoryImpl): LampRepository

    //State
    @Binds
    fun bindGetStateUseCase(
        impl: GetStateUseCaseImpl
    ): GetStateUseCase

    @Binds
    fun bindTurnLampOnUseCase(
        impl: TurnLampOnUseCaseImpl
    ): TurnLampOnUseCase

    @Binds
    fun bindTurnLampOffUseCase(
        impl: ToggleLampUseCaseImpl
    ): ToggleLampUseCase

    //Colors
    @Binds
    fun bindGetColorsUseCase(
        impl: GetColorsUseCaseImpl
    ): GetColorsUseCase

    @Binds
    fun bindGetCurrentColorUseCase(
        impl: GetCurrentColorUseCaseImpl
    ): GetCurrentColorUseCase

    @Binds
    fun bindSetColorUseCase(
        impl: SetColorUseCaseImpl
    ): SetColorUseCase

    //Brightness
    @Binds
    fun bindGetBrightnessLevelsUseCase(
        impl: GetBrightnessLevelsUseCaseImpl
    ): GetBrightnessLevelsUseCase

    @Binds
    fun bindGetCurrentBrightnessUseCase(
        impl: GetCurrentBrightnessUseCaseImpl
    ): GetCurrentBrightnessUseCase

    @Binds
    fun bindSetBrightnessUseCase(
        impl: SetBrightnessUseCaseImpl
    ): SetBrightnessUseCase
}