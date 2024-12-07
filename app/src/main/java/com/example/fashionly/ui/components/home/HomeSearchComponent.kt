package com.example.fashionly.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeSearchComponent() {

    var textState by remember { mutableStateOf(TextFieldValue("")) }
    MaterialTheme {
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    OutlinedTextField(
                        value = textState,
                        onValueChange = { textState = it },
                        label = {
                            Text(
                                "Search clothes...",
                                color = Color.LightGray
                            )
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = Color.LightGray
                            )
                        },
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.colors().copy(

                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            //Border Color Settings
                            focusedIndicatorColor = Color.LightGray,
                            unfocusedIndicatorColor = Color.LightGray

                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(0.2f)
                ) {
                    FloatingActionButton(
                        onClick = { /*TODO: Add action*/ },
                        containerColor = Color.Black.copy(alpha = 0.90f),
                        contentColor = Color.White,
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = com.example.fashionly.R.drawable.filter),
                            contentDescription = "Search"
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeSearchComponentPreview() {
    MaterialTheme {
        HomeSearchComponent()
    }
}