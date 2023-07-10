package com.example.koinpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.koinpractice.ui.theme.KoinPracticeTheme
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MyViewModel by viewModel()
        super.onCreate(savedInstanceState)
        setContent {
            KoinPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        val data = viewModel.fetchData()
        Log.e("Koin Test In MainActivity", data)

        // 因為有使用 Koin ，它會去解析 DataManager 的建構子需要 ApiService
        // 因此傳入 ApiService 的實例 ApiServiceImpl
        val dataManager: DataManager = get()
        dataManager.displayData()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KoinPracticeTheme {
        Greeting("Android")
    }
}