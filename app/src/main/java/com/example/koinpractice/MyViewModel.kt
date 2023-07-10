package com.example.koinpractice

import androidx.lifecycle.ViewModel

class MyViewModel(private val repository: MyRepository) : ViewModel() {
    // ViewModel 的相關邏輯
    fun fetchData(): String {
        return repository.fetchDataFromApi()
    }
}