package com.geekbrains.weatherwithmvvm.model.entities

import com.geekbrains.weatherwithmvvm.model.entities.City

data class Weather(
    val city: City = getDefaultCity(),
    val temperature: Int = 0,
    val feelsLike: Int = 0
)

fun getDefaultCity() = City("Москва", 55.755826, 37.617299900000035)