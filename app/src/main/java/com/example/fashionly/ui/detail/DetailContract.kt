package com.example.fashionly.ui.detail

import com.example.fashionly.ui.home.HomeContract.UiAction

object DetailContract {
    data class UiState(
        val isLoading: Boolean = false,
        val list: List<String> = emptyList(),
    )

    sealed class UiAction {
        object NavigateToCheckout : UiAction()
    }

    sealed class UiEffect {
        object NavigateToCheckout : UiEffect()
    }

}