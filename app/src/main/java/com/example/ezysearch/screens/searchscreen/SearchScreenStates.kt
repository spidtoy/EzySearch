package com.example.ezysearch.screens.searchscreen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ezysearch.R
import com.example.ezysearch.model.EzySearchUiState

@Composable
fun SearchScreenStates(uiState: EzySearchUiState, navParameter: () -> Unit, modifier: Modifier = Modifier) {
    when (uiState) {
        is EzySearchUiState.Loading -> CircularProgressIndicator()
        is EzySearchUiState.Success -> LaunchedEffect(Unit) { navParameter() }
        is EzySearchUiState.Error -> ErrorScreen(modifier)
        is EzySearchUiState.Start -> {}
    }
}


@Composable
fun ErrorScreen (modifier: Modifier) {
    Text(text = stringResource(R.string.fail_message), textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.error, modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 40.dp))
}