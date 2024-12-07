package com.example.fashionly.ui.home

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HomeScreenPreviewProvider : PreviewParameterProvider<HomeContract.UiState> {
    override val values: Sequence<HomeContract.UiState>
        get() = sequenceOf(
            HomeContract.UiState(
                isLoading = true,
                list = emptyList(),
            ),
            HomeContract.UiState(
                isLoading = false,
                list = emptyList(),
            ),
            HomeContract.UiState(
                isLoading = false,
                list = listOf("Item 1", "Item 2", "Item 3")
            ),
        )
}