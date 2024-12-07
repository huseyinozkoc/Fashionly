package com.example.fashionly.ui.components.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fashionly.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeListComponent(homeChipData: List<HomeChipModel>) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { homeChipData.size }
    )
    val coroutineScope = rememberCoroutineScope()

    MaterialTheme {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(homeChipData.size) { index ->
                    HomeChips(
                        chipText = homeChipData[index].chipText,
                        isSelected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(index)
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth()
            ) { page ->
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    verticalItemSpacing = 4.dp,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth()
                        .height(600.dp)
                ) {
                    items(homeChipData[page].items.size) { index ->
                        HomeListItem(
                            imageSource = homeChipData[page].items[index].imageSource,
                            nameText = homeChipData[page].items[index].nameText,
                            typeText = homeChipData[page].items[index].typeText,
                            priceText = homeChipData[page].items[index].priceText,
                            ratingText = homeChipData[page].items[index].ratingText
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeListComponentPreview() {
    MaterialTheme {
        HomeListComponent(homeChipData)
    }
}


data class HomeListItemModel(
    val imageSource: Int,
    val nameText: String,
    val typeText: String,
    val priceText: String,
    val ratingText: String
)

data class HomeChipModel(
    val chipText: String,
    val items: List<HomeListItemModel>
)

val homeChipData:List<HomeChipModel> = listOf(
    HomeChipModel(
        chipText = "All",
        items = listOf(
            HomeListItemModel(
                R.drawable.model,
                "Modern Light Clothes",
                "T-Shirt",
                "$212.99",
                "4.5"
            ),
            HomeListItemModel(R.drawable.model2, "Elegant Dress", "Dress", "$150.00", "4.8"),
            HomeListItemModel(R.drawable.model3, "Casual Pants", "Pants", "$99.99", "4.2"),
            HomeListItemModel(R.drawable.model4, "Running Shoes", "Shoes", "$120.00", "4.7"),
            HomeListItemModel(R.drawable.model, "Summer T-Shirt", "T-Shirt", "$45.00", "4.3")
        )
    ),
    HomeChipModel(
        chipText = "Dress",
        items = listOf(
            HomeListItemModel(R.drawable.model2, "Elegant Dress", "Dress", "$150.00", "4.8")
        )
    ),
    HomeChipModel(
        chipText = "T-Shirt",
        items = listOf(
            HomeListItemModel(
                R.drawable.model3,
                "Modern Light Clothes",
                "T-Shirt",
                "$212.99",
                "4.5"
            ),
            HomeListItemModel(R.drawable.model4, "Summer T-Shirt", "T-Shirt", "$45.00", "4.3")
        )
    ),
    HomeChipModel(
        chipText = "Pants",
        items = listOf(
            HomeListItemModel(R.drawable.model2, "Casual Pants", "Pants", "$99.99", "4.2")
        )
    ),
    HomeChipModel(
        chipText = "Shoes",
        items = listOf(
            HomeListItemModel(R.drawable.model, "Running Shoes", "Shoes", "$120.00", "4.7")
        )
    )
)