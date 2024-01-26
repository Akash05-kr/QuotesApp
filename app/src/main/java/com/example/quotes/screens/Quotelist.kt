package com.example.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotes.models.Quote
import com.example.quotes.screens.QuoteItemList


@Composable
fun Quotelist(data:Array<Quote>, onclick:(quote: Quote)->Unit) {

    LazyColumn(content = {
        items(data){
        QuoteItemList(quote = it,onclick)
    } })
}