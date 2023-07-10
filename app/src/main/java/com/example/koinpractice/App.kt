package com.example.koinpractice

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.dsl.module

class App : Application() {
    private val myModule = module {
        // 當程式碼中需要使用到 ApiService 實例時，就會以 singleton 的 ApiServiceImpl 實作
        // 今天當我需要替換實作為 NewApiServiceImpl ，我只需要在這裡改實作方式就好
        // 所有地方是使用 ApiService 這個介面的實例，但由哪個 class 實作是由 Koin 判斷
        // 類似寫法 single{ ApiServiceImpl() as ApiService}
        single<ApiService> { ApiServiceImpl() }
        single { MyRepository(get()) }
        single {DataManager(get())}

        // 這是一個叫做 viewModel() 的方法
        // 需要 ViewModel 時就呼叫 viewModel() 創立 ViewModel 的實例 MyViewModel
        // 創建時發現 MyViewModel 的建構子需要 MyRepository 的實例
        viewModel { MyViewModel(get()) }
    }
    override fun onCreate() {
        super.onCreate()
        // 啟動 Koin 框架
        startKoin {
            // 傳遞 module ， Koin 就會以我們定義 module 的方式解析並提供 ApiService 的實例
            androidContext(this@App)
            modules(myModule)
        }
    }
}