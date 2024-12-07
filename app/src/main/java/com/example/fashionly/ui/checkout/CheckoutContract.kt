package com.example.fashionly.ui.checkout

object CheckoutContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction {
        object NavigateToSplash : UiAction()
        object NavigateToDetail : UiAction()
    }

    sealed class UiEffect {
        object NavigateToSplash : UiEffect()
        object NavigateToDetail : UiEffect()
    }
}