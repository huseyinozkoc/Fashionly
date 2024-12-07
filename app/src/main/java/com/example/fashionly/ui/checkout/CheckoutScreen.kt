package com.example.fashionly.ui.checkout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.fashionly.ui.checkout.CheckoutContract.UiAction
import com.example.fashionly.ui.checkout.CheckoutContract.UiEffect
import com.example.fashionly.ui.checkout.CheckoutContract.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun CheckoutScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    navController: NavController,
) {

    LaunchedEffect(uiEffect) {
        uiEffect.collect { effect ->
            when (effect) {
                is UiEffect.NavigateToSplash -> {
                    navController.navigate("Splash")
                }

                is UiEffect.NavigateToDetail -> {
                    navController.navigate("Detail")
                }
            }
        }
    }


    when {
        uiState.isLoading -> LoadingBar()
        uiState.list.isNotEmpty() -> EmptyScreen()
        else -> CheckoutContent(onAction)
    }
}

@Composable
fun CheckoutContent(onAction: (UiAction) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = {
                onAction(UiAction.NavigateToDetail)
            }),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Checkout Content",
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview(
    @PreviewParameter(CheckoutScreenPreviewProvider::class) uiState: UiState,
) {
    val navController = rememberNavController()

    CheckoutScreen(
        uiState = uiState,
        uiEffect = emptyFlow(),
        onAction = {},
        navController = navController,
    )
}