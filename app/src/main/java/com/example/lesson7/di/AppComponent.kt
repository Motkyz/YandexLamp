package com.example.lesson7.di

import com.example.lesson7.di.viewModel.ViewModelModule
import com.example.lesson7.presenter.MainFragment
import dagger.Component
import dagger.Module

@Component(
    modules = [AppModule::class]
)
abstract class AppComponent{
    abstract fun inject(fragment: MainFragment)
}

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class
    ]
)
class AppModule