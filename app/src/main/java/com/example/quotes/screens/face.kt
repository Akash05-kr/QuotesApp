package com.example.quotes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.models.Quote

@Composable
fun QuoteItemList(quote: Quote,onClick:(quote: Quote)->Unit) {
    Card(
        modifier = Modifier.clickable { onClick(quote) }
            .padding(8.dp).height(110.dp),
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
                .height(100.dp)

        ) {
            Image(
                imageVector = Icons.Filled.Face,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "Quote",
                modifier = Modifier
                    .size(50.dp)
                    .rotate(180F)
                    .background(Color.Black)

            )
            Spacer(modifier = Modifier.size(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(8.dp))
                Box(
                    modifier = Modifier
                        .background(color = Color.DarkGray)
                        .height(2.dp)
                        .fillMaxSize(.4f)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }

}
