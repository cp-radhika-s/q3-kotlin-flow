package com.canopas.campose.kotlinflow_openweather.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canopas.campose.kotlinflow_openweather.data.CurrentWeatherResponse
import com.canopas.campose.kotlinflow_openweather.data.fivedayweather.FiveDayResponse
import com.canopas.campose.kotlinflow_openweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: WeatherRepository) : ViewModel() {

    val currentWeather = MutableLiveData<CurrentWeatherResponse>()
    val fiveDayHourlyWeather = MutableLiveData<FiveDayResponse>()
    val showError = MutableLiveData<String>()

    fun loadCurrentWeather(query: String) {
        viewModelScope.launch {
            repository.getCurrentWeather(query)
                .catch { t ->
                    showError.value = t.localizedMessage
                }
                .collect {
                    currentWeather.value = it
                }
        }
    }

    fun getFiveDaysHourlyWeather(query: String) {
        viewModelScope.launch {
            repository.getFiveDaysHourlyWeather(query)
                .catch { t ->
                    showError.value = t.localizedMessage
                }
                .collect {
                    fiveDayHourlyWeather.value = it
                }
        }

    }
}