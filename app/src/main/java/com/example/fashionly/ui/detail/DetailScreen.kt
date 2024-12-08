package com.example.fashionly.ui.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.fashionly.ui.components.EmptyScreen
import com.example.fashionly.ui.components.LoadingBar
import com.example.fashionly.ui.components.detail.DetailScreenColorAndSizeSelectorComponent
import com.example.fashionly.ui.components.detail.DetailScreenExplanationComponent
import com.example.fashionly.ui.components.detail.DetailScreenImageComponent
import com.example.fashionly.ui.detail.DetailContract.UiAction
import com.example.fashionly.ui.detail.DetailContract.UiEffect
import com.example.fashionly.ui.detail.DetailContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun DetailScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    navController: NavController
) {

    LaunchedEffect(uiEffect) {
        uiEffect.collect { effect ->
            when (effect) {
                is UiEffect.NavigateToCheckout -> {
                    navController.navigate("Checkout")
                }
            }
        }
    }

    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> DetailContent(onAction)
    }
}

@Composable
fun DetailContent(onAction: (UiAction) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = {
            }),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            DetailScreenImageComponent()

            HorizontalDivider(
                color = Color.LightGray,
                thickness = 0.5.dp,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 4.dp)
            )

            DetailScreenExplanationComponent()

            HorizontalDivider(
                color = Color.LightGray,
                thickness = 0.5.dp,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            DetailScreenColorAndSizeSelectorComponent()

            HorizontalDivider(
                color = Color.LightGray,
                thickness = 0.5.dp,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 16.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(
    @PreviewParameter(DetailScreenPreviewProvider::class) uiState: UiState,
) {
    val navController = rememberNavController()

    DetailScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
        navController = navController
    )
}