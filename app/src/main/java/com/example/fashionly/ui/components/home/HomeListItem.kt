package com.example.fashionly.ui.components.home

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.div


@Composable
fun HomeListItem(
    imageSource: Int,
    nameText: String,
    typeText: String,
    priceText: String,
    ratingText: String,
) {
    var isFav by remember { mutableStateOf(false) }

    MaterialTheme {
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .width(LocalConfiguration.current.screenWidthDp.dp / 3)
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                // Image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(LocalConfiguration.current.screenHeightDp.dp / 4.3f)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Image(
                        painter = painterResource(id = imageSource),
                        contentDescription = "Image",
                        contentScale = androidx.compose.ui.layout.ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize(),
                    )

                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(24.dp)
                            .background(
                                color = Color.Black,
                                shape = androidx.compose.foundation.shape.CircleShape
                            ).clickable {
                                isFav = !isFav
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Icon",
                            tint = if (isFav) Color.Red else Color.White,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }

                // Name
                Text(
                    text = nameText,
                    color = Color.Black,
                    fontSize = 10.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )

                // Type
                Text(
                    text = typeText,
                    color = Color.Gray,
                    fontSize = 8.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Thin,
                    modifier = Modifier.fillMaxWidth()
                )

                // Price And Rating
                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(modifier = Modifier.weight(3f)) { // Price
                        Text(
                            text = priceText,
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                            modifier = Modifier
                        )
                    }

                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) { // Rating
                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Icon",
                            tint = Color.Yellow,
                            modifier = Modifier.size(12.dp)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = ratingText,
                            color = Color.Black,
                            fontSize = 10.sp,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeListItemPreview() {
    MaterialTheme {
        HomeListItem(
            imageSource = com.example.fashionly.R.drawable.model,
            nameText = "Modern Light Clothes",
            typeText = "T-Shirt",
            priceText = "$212.99",
            ratingText = "4.5"
        )
    }
}