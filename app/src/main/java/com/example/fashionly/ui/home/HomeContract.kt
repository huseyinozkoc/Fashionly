package com.example.fashionly.ui.home

object HomeContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction {
        object NavigateToDetail : UiAction()
    }

    sealed class UiEffect {
        object NavigateToDetail : UiEffect()
    }
}