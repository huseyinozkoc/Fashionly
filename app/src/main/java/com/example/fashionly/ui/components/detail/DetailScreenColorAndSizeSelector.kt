package com.example.fashionly.ui.components.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding


@Composable
fun DetailScreenColorAndSizeSelectorComponent() {

    var selectedSize by remember { mutableStateOf("M") }
    val sizes = listOf("S", "M", "L", "XL")
    var selectedColor by remember { mutableStateOf(Color.Red) }
    val colors = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)

    MaterialTheme {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)) {


            Row(modifier = Modifier.fillMaxSize()) {


                //Size
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Choose Size",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(sizes) { size ->
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(if (size == selectedSize) Color.Black else Color.White)
                                    .border(1.dp, Color.LightGray, CircleShape)
                                    .clickable { selectedSize = size },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = size,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = if (size == selectedSize) Color.White else Color.Black,
                                    modifier = Modifier
                                )
                            }
                        }
                    }
                }


                // Colors
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Color",
                        fontSize = 16.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        modifier = Modifier
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(colors) { color ->
                            Box(
                                modifier = Modifier
                                    .size(if (color == selectedColor) 36.dp else 24.dp)
                                    .clip(CircleShape)
                                    .background(if (color == selectedColor) selectedColor else color)
                                    .border(1.dp, Color.LightGray, CircleShape)
                                    .clickable { selectedColor = color },
                                contentAlignment = Alignment.Center
                            ) {

                            }
                        }
                    }


                }

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenColorAndSizeSelectorComponentPreview() {
    MaterialTheme {
        DetailScreenColorAndSizeSelectorComponent()
    }
}