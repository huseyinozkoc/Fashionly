package com.example.fashionly.ui.components.checkout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fashionly.R

@Composable
fun CheckoutList() {
    val items = listOf(
        CheckoutItem(R.drawable.model13, "Modern Light Clothes", "Dress Modern", "$162.99", 1),
        CheckoutItem(R.drawable.model14, "Casual Shirt", "Shirt", "$45.00", 2),
        CheckoutItem(R.drawable.model12, "Elegant Dress", "Dress", "$120.50", 1)
    )

    var height = items.size * 132

    MaterialTheme {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(height.dp),
            contentAlignment = Alignment.Center
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items) { item ->
                    CheckoutListItem(item = item)
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 0.5.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutListPreview() {
    MaterialTheme {
        CheckoutList()
    }
}