package com.example.fashionly.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeWelcomeComponent() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = "Hello, Welcome 👋",
                        color = Color.Gray.copy(alpha = 0.7f),
                        fontSize = 12.sp
                    )

                    Text(
                        text = "Albert Stevano",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize(),
                    verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = painterResource(id = com.example.fashionly.R.drawable.profile),
                        contentDescription = "Welcome Image",
                        modifier = Modifier
                            .size(50.dp)
                    )
                }

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeWelcomeComponentPreview() {
    MaterialTheme {
        HomeWelcomeComponent()
    }
}