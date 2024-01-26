package com.example.quotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.DataManager
import com.example.quotes.models.Quote

@Composable
fun Behind(quote: Quote) {

    BackHandler {
        DataManager.switchPages(null)

    }


    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFF1F0E6),
                        Color(0xFF4255D6)
                    )
                )
            ),

        ){
        Card(
            modifier = Modifier
                .padding(5.dp)
                .height(200.dp)
                .fillMaxSize(1F),
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .height(200.dp)

            ) {
                Image(
                    imageVector = Icons.Filled.Face,
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(180F)
                        .background(Color.Black)

                )
                Spacer(modifier = Modifier.size(8.dp))
                Column(modifier = Modifier
                    .weight(1f)
                    .height(100.dp)) {
                    Text(
                        text = quote.text,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.size(20.dp))

                    Text(
                        text = quote.author,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}