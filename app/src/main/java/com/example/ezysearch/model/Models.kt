package com.example.ezysearch.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration


data class StringStates (
    val searchText: String = "",
    val networkResult: String = "")


sealed interface EzySearchUiState {
    object Success : EzySearchUiState
    object Error : EzySearchUiState
    object Loading : EzySearchUiState
    object Start: EzySearchUiState
}

data class PagesModelClass(
    val kind: String,
    val items: ArrayList<Page>
)

data class Page(
    val link: String,
    val snippet: String
)

class Size{
    @Composable
    fun height(): Int {
        val configuration = LocalConfiguration.current
        return configuration.screenHeightDp
    }
    @Composable
    fun width(): Int {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp
    }
}