package com.example.koinpractice

import android.util.Log

class DataManager(private val apiService: ApiService) {
    fun displayData() {
        val data = apiService.fetchData()
        Log.e("Koin Test In DataManager",data)
    }
}