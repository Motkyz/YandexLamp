package com.example.lesson7.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson7.domain.GetDogsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase
): ViewModel() {
    private val _dogImageUrl =MutableLiveData<String>()
    val dogImageUrl:LiveData<String>
        get() = _dogImageUrl

    fun loadNewDog() {
        viewModelScope.launch {
            val dogInfo = getDogsUseCase()

            _dogImageUrl.postValue(
                dogInfo?.url
            )
        }


        _dogImageUrl.postValue(
            "https://random.dog/2b9be14d-f084-4cbc-a266-35cc02ff62e9.gif"
        )
    }



}