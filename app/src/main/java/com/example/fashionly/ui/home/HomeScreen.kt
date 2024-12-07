package com.example.fashionly.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fashionly.ui.components.EmptyScreen
import com.example.fashionly.ui.components.LoadingBar
import com.example.fashionly.ui.components.home.HomeChipModel
import com.example.fashionly.ui.components.home.HomeListComponent
import com.example.fashionly.ui.components.home.HomeSearchComponent
import com.example.fashionly.ui.components.home.HomeWelcomeComponent
import com.example.fashionly.ui.components.home.homeChipData
import com.example.fashionly.ui.home.HomeContract.UiAction
import com.example.fashionly.ui.home.HomeContract.UiEffect
import com.example.fashionly.ui.home.HomeContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun HomeScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    navController: NavController
) {
    LaunchedEffect(uiEffect) {
        uiEffect.collect { effect ->
            when (effect) {
                is UiEffect.NavigateToDetail -> {
                    navController.navigate("Detail")
                }
            }
        }
    }

    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> HomeContent(onAction)
    }
}

@Composable
fun HomeContent(onAction: (UiAction) -> Unit) {

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            HomeWelcomeComponent()
        }
        item {
            HomeSearchComponent()
        }
        item {
            HomeListComponent(homeChipData)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(
    @PreviewParameter(HomeScreenPreviewProvider::class) uiState: UiState,
) {
    val navController = rememberNavController()

    HomeScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
        navController
    )
}