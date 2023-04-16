package com.example.ezysearch.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ezysearch.screens.pagescreen.Pages
import com.example.ezysearch.screens.searchscreen.SearchScreen
import com.example.ezysearch.screens.searchscreen.SearchScreenViewModel

@Composable
fun EzySearchApp (
    modifier: Modifier = Modifier,
    searchScreenViewModel: SearchScreenViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
    ) {
    Scaffold() { innerPadding ->
        val stringStates = searchScreenViewModel.stringStates
        val ezySearchUiState = searchScreenViewModel.ezySearchUiState
        val pageList = searchScreenViewModel.pageList
        NavHost(
            navController = navController,
            startDestination = EzySearchScreen.Search.name,
            modifier = modifier.padding(innerPadding)
        ){
            composable(route = EzySearchScreen.Search.name) {
                SearchScreen(
                    searchText =  stringStates.searchText,
                    onValueChange = searchScreenViewModel::updateSearchField,
                    onTextCleared =  searchScreenViewModel::onTextCleared,
                    onGoButtonClicked = searchScreenViewModel::getSearchResults,
                    navigateToPages = { navController.navigate(EzySearchScreen.Pages.name) },
                    ezySearchUiState = ezySearchUiState
                )
            }
            composable(route = EzySearchScreen.Pages.name) {
                Pages(list = pageList, resetEzySearUiState = searchScreenViewModel::resetEzySearUiState)
            }
        }
    }
}