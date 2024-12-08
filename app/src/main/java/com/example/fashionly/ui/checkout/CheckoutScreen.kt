package com.example.fashionly.ui.checkout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.fashionly.ui.checkout.CheckoutContract.UiAction
import com.example.fashionly.ui.checkout.CheckoutContract.UiEffect
import com.example.fashionly.ui.checkout.CheckoutContract.UiState
import com.example.fashionly.ui.components.checkout.CheckoutInfoComponent
import com.example.fashionly.ui.components.checkout.CheckoutList
import com.example.fashionly.ui.components.checkout.CheckoutPayButton
import com.example.fashionly.ui.components.checkout.CheckoutTopBar
import com.example.fashionly.ui.components.detail.DetailScreenAddCardButton
import com.example.fashionly.ui.components.detail.DetailScreenColorAndSizeSelectorComponent
import com.example.fashionly.ui.components.detail.DetailScreenExplanationComponent
import com.example.fashionly.ui.components.detail.DetailScreenImageComponent
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
            }),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CheckoutTopBar()

            Spacer(modifier = Modifier.height(8.dp))

            CheckoutList()

            Spacer(modifier = Modifier.height(8.dp))

            CheckoutInfoComponent()



        } //  End of Column

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .align(Alignment.BottomCenter)) {
            CheckoutPayButton()
        }

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