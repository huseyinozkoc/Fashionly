package com.example.fashionly.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeChips(
    chipText : String = "All",
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    val backgroundColor = if (isSelected) Color.Black else Color.White
    val borderColor = if (isSelected) Color.Black else Color.LightGray
    val textColor = if (isSelected) Color.White else Color.Black
    val iconColor = if (isSelected) Color.White else Color.Black

    MaterialTheme {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .width(LocalConfiguration.current.screenWidthDp.dp / 3)
                .height(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color = backgroundColor)
                .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(8.dp))
                .clickable { onClick() }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = com.example.fashionly.R.drawable.dress),
                    contentDescription = "Icon",
                    tint = iconColor,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = chipText,
                    color = textColor,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeChipsPreview() {
    MaterialTheme {
        HomeChips()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeChipsPreview2() {
    MaterialTheme {
        HomeChips("Dress",true)
    }
}