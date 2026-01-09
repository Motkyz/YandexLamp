package com.example.lesson7.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson7.data.model.BrightnessLevelsInfo
import com.example.lesson7.data.model.ColorInfo
import com.example.lesson7.domain.brightnessUseCases.GetBrightnessLevelsUseCase
import com.example.lesson7.domain.colorUseCases.GetColorsUseCase
import com.example.lesson7.domain.brightnessUseCases.GetCurrentBrightnessUseCase
import com.example.lesson7.domain.colorUseCases.GetCurrentColorUseCase
import com.example.lesson7.domain.stateUseCases.GetStateUseCase
import com.example.lesson7.domain.brightnessUseCases.SetBrightnessUseCase
import com.example.lesson7.domain.colorUseCases.SetColorUseCase
import com.example.lesson7.domain.stateUseCases.ToggleLampUseCase
import com.example.lesson7.domain.stateUseCases.TurnLampOnUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getStateUseCase: GetStateUseCase,
    private val turnLampOnUseCase: TurnLampOnUseCase,
    private val toggleLampUseCase: ToggleLampUseCase,
    private val getColorsUseCase: GetColorsUseCase,
    private val getCurrentColorUseCase: GetCurrentColorUseCase,
    private val setColorUseCase: SetColorUseCase,
    private val getBrightnessLevelsUseCase: GetBrightnessLevelsUseCase,
    private val getCurrentBrightnessUseCase: GetCurrentBrightnessUseCase,
    private val setBrightnessUseCase: SetBrightnessUseCase,
): ViewModel() {

    init {
        getState()
        getBrightnessLevels()
        getCurrentBrightness()
        loadColors()
        getCurrentColor()
    }

    //State
    private val _lampState = MutableLiveData<Boolean>()
    val lampState: LiveData<Boolean>
        get() = _lampState

    fun getState(){
        viewModelScope.launch {
            val state = getStateUseCase()

            _lampState.postValue(
                state ?: false
            )
        }
    }

    fun turnLampOn() {
        viewModelScope.launch {
            val success = turnLampOnUseCase()

            if (success == true) {
                _lampState.postValue(
                    true
                )
            }
        }
    }

    fun turnLampOff() {
        viewModelScope.launch {
            val success = toggleLampUseCase()

            if (success == true) {
                _lampState.postValue(
                    false
                )
            }
        }
    }

    fun toggleLamp() {
        viewModelScope.launch {
            val state = getStateUseCase()

            when (state) {
                false -> {
                    turnLampOn()
                }
                true -> {
                    turnLampOff()
                }
                else -> {}
            }
        }
    }

    //Colors
    private val _colorsList = MutableLiveData<List<ColorInfo>>()
    val colorsList: LiveData<List<ColorInfo>>
        get() = _colorsList

    fun loadColors() {
        viewModelScope.launch {
            val colorsInfo = getColorsUseCase()

            _colorsList.postValue(
                colorsInfo ?: listOf()
            )
        }
    }

    private val _currentColor = MutableLiveData<ColorInfo>()
    val currentColor: LiveData<ColorInfo>
        get() = _currentColor

    fun getCurrentColor() {
        viewModelScope.launch {
            val colorInfo = getCurrentColorUseCase()

            _currentColor.postValue(
                colorInfo ?: ColorInfo(
                        id = 1337, "WHITE", "WHITE", "white"
                )
            )
        }
    }

    fun setColor(color: String) {
        viewModelScope.launch {
            val success = setColorUseCase(color)

            if (success == true) {
                val colorInfo = colorsList.value?.find { it.color == color }

                _currentColor.postValue(
                    colorInfo ?: ColorInfo(
                        id = 1337, "WHITE", "WHITE", "white"
                    )
                )
            }
        }
    }

    //Brightness
    private val _brightnessLevels = MutableLiveData<BrightnessLevelsInfo>()
    val brightnessLevels: LiveData<BrightnessLevelsInfo>
        get() = _brightnessLevels

    fun getBrightnessLevels() {
        viewModelScope.launch {
            val brightnessLevelsInfo = getBrightnessLevelsUseCase()

            _brightnessLevels.postValue(
                brightnessLevelsInfo ?: BrightnessLevelsInfo(
                    100, 0, 1
                )
            )
        }
    }

    private val _currentBrightness = MutableLiveData<Int>()
    val currentBrightness: LiveData<Int>
        get() = _currentBrightness

    fun getCurrentBrightness() {
        viewModelScope.launch {
            val brightness = getCurrentBrightnessUseCase()

            _currentBrightness.postValue(
                brightness ?: 0
            )
        }
    }

    fun setBrightness(brightness: Int) {
        viewModelScope.launch {
            val success = setBrightnessUseCase(brightness)

            if (success == true) {
                _currentBrightness.postValue(
                    brightness
                )
            }
        }
    }
}