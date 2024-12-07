package com.example.fashionly.ui.checkout

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class CheckoutScreenPreviewProvider : PreviewParameterProvider<CheckoutContract.UiState> {
    override val values: Sequence<CheckoutContract.UiState>
        get() = sequenceOf(
            CheckoutContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            CheckoutContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            CheckoutContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}