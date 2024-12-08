package com.example.fashionly.ui.components.detail

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fashionly.R


@Composable
fun DetailScreenExplanationComponent() {
    var expanded by remember { mutableStateOf(false) }
    var quantity by remember { mutableStateOf(1) }
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "Light Dress Bless",
                        fontSize = 16.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                        color = Color.Black,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Star,
                            tint = Color(0xFFE5C558),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .size(10.dp)
                        )
                        Text(
                            text = buildAnnotatedString {
                                append("4.5 ")
                                withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.Bold)) {
                                    append("(355 Reviews)")
                                }
                            },
                            fontSize = 6.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 3.dp)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {

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
                            modifier = Modifier.padding(horizontal = 8.dp)
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


            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque viverra risus libero, in mattis felis euismod sed. Suspendisse quis urna hendrerit, convallis tortor sed, ornare tellus. Curabitur egestas vulputate cursus. Nullam et eleifend est, id maximus quam. Curabitur imperdiet nibh imperdiet elit euismod venenatis. Cras ullamcorper hendrerit justo, a laoreet ex vestibulum eget. Fusce sodales suscipit pulvinar. Integer dui tellus, pulvinar vel semper interdum, aliquam ac arcu. Nulla facilisi. Nam hendrerit pretium volutpat. Cras commodo eros a felis molestie iaculis. Aliquam massa metus, sollicitudin et iaculis nec, rutrum sed tortor. In congue volutpat molestie. Duis quis massa fermentum, interdum nisi vel, posuere tellus. Nulla eget enim id dui dictum molestie. Curabitur a sollicitudin erat.",
                color = Color.Black,
                fontSize = 6.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                maxLines = if (expanded) Int.MAX_VALUE else 3,
                overflow = TextOverflow.Ellipsis,
                lineHeight = 8.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .animateContentSize()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Read More",
                    color = Color.Black,
                    fontSize = 8.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                    modifier = Modifier.padding(start = 8.dp)
                )

                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    tint = Color.Black,
                    contentDescription = null,
                    modifier = Modifier.size(8.dp)
                )
            }


        }


    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenShowMapComponentPreview() {
    MaterialTheme {
        DetailScreenExplanationComponent()
    }
}