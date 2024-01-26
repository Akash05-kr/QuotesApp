package com.example.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.DataManager.currentPage
import com.example.quotes.models.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLodded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context){
        val inputStream = context.assets.open("Quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLodded.value = true
    }

    fun switchPages(it: Quote?) {

    }
}
fun swichPages(quote: Quote?){
    if(currentPage.value == Pages.LISTING){
        currentPage = quote
        currentPage.value = Pages.DETAIL
    }else{
        currentPage.value = Pages.LISTING
    }
}