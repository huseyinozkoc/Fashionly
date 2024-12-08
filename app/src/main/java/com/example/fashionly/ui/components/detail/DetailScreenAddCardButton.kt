package com.example.fashionly.ui.components.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fashionly.R


@Composable
fun DetailScreenAddCardButton(onButtonClick: () -> Unit ) {
    MaterialTheme {
        Box(
            modifier = Modifier
                .clickable(onClick = onButtonClick)
                .background(color = Color.Black, shape = RoundedCornerShape(24.dp))
                .padding(horizontal = 16.dp)
                .height(50.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.shopping_icon),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "Add to Card", color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )

                Spacer(modifier = Modifier.size(8.dp))

                VerticalDivider(
                    color = Color.White,
                    thickness = 1.dp,
                    modifier = Modifier.height(24.dp)
                )

                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "$162.99", color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(8.dp))

                Text(
                    text = "$190.99", color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    textDecoration = TextDecoration.LineThrough
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenAddCardButtonPreview() {
    MaterialTheme {
        DetailScreenAddCardButton(onButtonClick = {})
    }
}