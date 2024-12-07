package com.example.fashionly.ui.detail

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class DetailScreenPreviewProvider : PreviewParameterProvider<DetailContract.UiState> {
    override val values: Sequence<DetailContract.UiState>
        get() = sequenceOf(
            DetailContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            DetailContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            DetailContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}