package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import com.example.quotes.screens.Behind
import com.example.quotes.screens.QuotelistScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLodded.value){
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuotelistScreen(data = DataManager.data) {
           DataManager.switchPages(it)
            }
        }
        else{
            DataManager.currentQuote?.let { Behind(quote = it) }

        }
    }

    else{
        Box {
            Text(text = "Loading...",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
        }
    }
}
enum class Pages{
    LISTING,
    DETAIL
}




