package com.example.fashionly.ui.components.checkout

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fashionly.R


@Composable
fun CheckoutDropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("**** **** **** 2143") }
    var selectedLogo by remember { mutableStateOf(R.drawable.visa) }
    val rotation by animateFloatAsState(if (expanded) 180f else 0f, label = "")


    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Shipping Information",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { expanded = true }
                    .background(Color.LightGray.copy(alpha = 0.8f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = selectedLogo),
                            contentDescription = "Image 1",
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = selectedItem,
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Image(
                            painter = painterResource(id = R.drawable.arrowbelow),
                            contentDescription = "Image 2",
                            modifier = Modifier
                                .size(24.dp)
                                .rotate(rotation)
                        )
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .background(Color.White)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth()
                    ) {
                        CustomDropdownMenuItem(
                            text = "**** **** **** 1234",
                            imageResId1 = R.drawable.mastercard,
                            imageResId2 = R.drawable.menu1,
                            onClick = {
                                selectedItem = "**** **** **** 1234"
                                selectedLogo = R.drawable.mastercard
                                expanded = false
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomDropdownMenuItem(
                            text = "**** **** **** 5678",
                            imageResId1 = R.drawable.americanexpress,
                            imageResId2 = R.drawable.menu1,
                            onClick = {
                                selectedItem = "**** **** **** 5678"
                                selectedLogo = R.drawable.americanexpress
                                expanded = false
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        CustomDropdownMenuItem(
                            text = "**** **** **** 9101",
                            imageResId1 = R.drawable.visa,
                            imageResId2 = R.drawable.menu1,
                            onClick = {
                                selectedItem = "**** **** **** 9101"
                                selectedLogo = R.drawable.visa
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomDropdownMenuItem(text: String, imageResId1: Int, imageResId2: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .background(Color.LightGray.copy(alpha = 0.8f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId1),
                contentDescription = "Image 1",
                modifier = Modifier.size(36.dp)
            )
            Text(
                text = text,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = imageResId2),
                contentDescription = "Image 2",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutDropdownMenuPreview() {
    MaterialTheme {
        CheckoutDropdownMenu()
    }
}