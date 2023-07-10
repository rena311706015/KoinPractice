package com.example.koinpractice

class MyRepository(private val apiService: ApiService) {
    fun fetchDataFromApi(): String {
        return apiService.fetchData()
    }
}