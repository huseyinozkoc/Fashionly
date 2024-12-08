package com.example.fashionly.ui.components.checkout

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fashionly.R


@Composable
fun CheckoutListItem(item: CheckoutItem) {
    var quantity by remember { androidx.compose.runtime.mutableIntStateOf(item.quantity) }
    var offsetY by remember { mutableStateOf(0.dp) }

    LaunchedEffect(quantity) {
        offsetY = if (quantity > item.quantity) -20.dp else 20.dp
        offsetY = 0.dp
    }

    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.fillMaxSize()) {

                // Image
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.4f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Image(
                            painter = painterResource(id = item.imageResId),
                            contentDescription = "Product Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = androidx.compose.ui.layout.ContentScale.Crop
                        )
                    }
                }

                // Item Details
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(8.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {

                    // Name Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.name,
                            fontSize = 12.sp,
                            color = Color.Black,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.menu1),
                            contentDescription = "Delete",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(24.dp)
                                .padding(end = 8.dp)
                        )
                    }

                    // Type Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.type,
                            fontSize = 10.sp,
                            color = Color.Gray,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Thin
                        )
                    }

                    // Price Row
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item.price,
                            fontSize = 12.sp,
                            color = Color.Black,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                        )

                        // Quantity Row
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                                    .border(1.dp, Color.LightGray, CircleShape)
                                    .clickable { if (quantity > 0) quantity-- },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_minus),
                                    contentDescription = null,
                                    tint = Color.Gray,
                                    modifier = Modifier.size(16.dp)
                                )
                            }

                            Text(
                                text = quantity.toString(),
                                fontSize = 12.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .offset(y = offsetY)
                                    .animateContentSize(animationSpec = tween(
                                        durationMillis = 500,
                                        easing = EaseInOut
                                    ))
                            )

                            Box(
                                modifier = Modifier
                                    .size(24.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                                    .border(1.dp, Color.LightGray, CircleShape)
                                    .clickable { quantity++ },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icon_add),
                                    contentDescription = null,
                                    tint = Color.Gray,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class CheckoutItem(
    val imageResId: Int,
    val name: String,
    val type: String,
    val price: String,
    val quantity: Int
)


@Preview(showBackground = true)
@Composable
fun CheckoutListItemPreview() {
    val sampleItem = CheckoutItem(
        imageResId = R.drawable.model13,
        name = "Modern Light Clothes",
        type = "Dress Modern",
        price = "$162.99",
        quantity = 1
    )
    MaterialTheme {
        CheckoutListItem(item = sampleItem)
    }
}