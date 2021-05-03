package com.geekbrains.weatherwithmvvm.ui.main

import androidx.lifecycle.*
import com.geekbrains.weatherwithmvvm.model.AppState
import com.geekbrains.weatherwithmvvm.model.Repository
import com.geekbrains.weatherwithmvvm.model.RepositoryImpl
import com.geekbrains.weatherwithmvvm.model.entities.Weather
import java.lang.Thread.sleep

class MainViewModel(private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData())
    : ViewModel(), LifecycleObserver {
    private val repository: Repository = RepositoryImpl()
    private val lifeCycleLiveData = MutableLiveData<String>()

    fun getLiveData() = liveDataToObserve

    fun getWeather() = getDataFromLocalSource()

    fun getData(): LiveData<AppState> {
        getDataFromLocalSource()
        return liveDataToObserve
    }

    fun getLifeCycleData() = lifeCycleLiveData

    fun getWeatherFromRemoteSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repository.getWeatherFromLocalStorage()))
        }.start()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onViewStart() {
        lifeCycleLiveData.value = "Start"
    }
}