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

val homeChipData: List<HomeChipModel> = listOf(
    HomeChipModel(
        chipText = "All",
        items = listOf(
            HomeListItemModel(R.drawable.model14, "Modern Light Clothes", "T-Shirt", "$212.99", "4.5"),
            HomeListItemModel(R.drawable.model7, "Elegant Dress", "Dress", "$150.00", "4.8"),
            HomeListItemModel(R.drawable.model8, "Casual Pants", "Pants", "$99.99", "4.2"),
            HomeListItemModel(R.drawable.model9, "Running Shoes", "Shoes", "$120.00", "4.7"),
            HomeListItemModel(R.drawable.model10, "Summer T-Shirt", "T-Shirt", "$45.00", "4.3"),
            HomeListItemModel(R.drawable.model11, "Winter Jacket", "Jacket", "$300.00", "4.9"),
            HomeListItemModel(R.drawable.model12, "Formal Suit", "Suit", "$500.00", "4.6"),
            HomeListItemModel(R.drawable.model13, "Casual Shirt", "Shirt", "$60.00", "4.4"),
            HomeListItemModel(R.drawable.model14, "Sportswear", "Activewear", "$80.00", "4.7"),
            HomeListItemModel(R.drawable.model9, "Denim Jacket", "Jacket", "$120.00", "4.5")
        )
    ),
    HomeChipModel(
        chipText = "Dress",
        items = listOf(
            HomeListItemModel(R.drawable.model, "Elegant Dress", "Dress", "$150.00", "4.8"),
            HomeListItemModel(R.drawable.model2, "Summer Dress", "Dress", "$120.00", "4.5"),
            HomeListItemModel(R.drawable.model3, "Cocktail Dress", "Dress", "$200.00", "4.7"),
            HomeListItemModel(R.drawable.model4, "Evening Gown", "Dress", "$350.00", "4.9")
        )
    ),
    HomeChipModel(
        chipText = "T-Shirt",
        items = listOf(
            HomeListItemModel(R.drawable.model4, "Modern Light Clothes", "T-Shirt", "$212.99", "4.5"),
            HomeListItemModel(R.drawable.model3, "Summer T-Shirt", "T-Shirt", "$45.00", "4.3"),
            HomeListItemModel(R.drawable.model2, "Graphic Tee", "T-Shirt", "$30.00", "4.4"),
            HomeListItemModel(R.drawable.model, "Plain T-Shirt", "T-Shirt", "$20.00", "4.2"),
            HomeListItemModel(R.drawable.model2, "V-Neck T-Shirt", "T-Shirt", "$25.00", "4.1"),
            HomeListItemModel(R.drawable.model3, "Long Sleeve Tee", "T-Shirt", "$35.00", "4.6"),
            HomeListItemModel(R.drawable.model, "Striped T-Shirt", "T-Shirt", "$40.00", "4.3"),
            HomeListItemModel(R.drawable.model4, "Pocket Tee", "T-Shirt", "$28.00", "4.5")
        )
    ),
    HomeChipModel(
        chipText = "Pants",
        items = listOf(
            HomeListItemModel(R.drawable.model3, "Casual Pants", "Pants", "$99.99", "4.2"),
            HomeListItemModel(R.drawable.model2, "Jeans", "Pants", "$60.00", "4.5"),
            HomeListItemModel(R.drawable.model4, "Chinos", "Pants", "$70.00", "4.3"),
            HomeListItemModel(R.drawable.model, "Shorts", "Pants", "$40.00", "4.0"),
            HomeListItemModel(R.drawable.model4, "Joggers", "Pants", "$50.00", "4.4"),
            HomeListItemModel(R.drawable.model, "Cargo Pants", "Pants", "$80.00", "4.6"),
            HomeListItemModel(R.drawable.model3, "Dress Pants", "Pants", "$90.00", "4.7"),
            HomeListItemModel(R.drawable.model2, "Sweatpants", "Pants", "$55.00", "4.3"),
            HomeListItemModel(R.drawable.model4, "Track Pants", "Pants", "$65.00", "4.5"),
            HomeListItemModel(R.drawable.model, "Leather Pants", "Pants", "$150.00", "4.8"),
            HomeListItemModel(R.drawable.model3, "Corduroy Pants", "Pants", "$70.00", "4.2"),
            HomeListItemModel(R.drawable.model2, "Linen Pants", "Pants", "$60.00", "4.1"),
            HomeListItemModel(R.drawable.model4, "Khakis", "Pants", "$75.00", "4.4"),
            HomeListItemModel(R.drawable.model, "Slim Fit Pants", "Pants", "$85.00", "4.6"),
            HomeListItemModel(R.drawable.model3, "Wide Leg Pants", "Pants", "$95.00", "4.7")
        )
    )
)