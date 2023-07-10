package com.example.koinpractice

class ApiServiceImpl  : ApiService {
    // 當我的這個 fun 需要改寫時，我只需要在這邊做變動
    // 這個變動就會被 Koin 調用到所有使用 ApiService 的程式區塊
    override fun fetchData(): String {
        return "Data from API"
    }
}