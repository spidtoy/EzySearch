package com.example.ezysearch.screens.searchscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ezysearch.model.EzySearchUiState
import com.example.ezysearch.model.Page
import com.example.ezysearch.model.PagesModelClass
import com.example.ezysearch.model.StringStates
import com.example.ezysearch.network.CX
import com.example.ezysearch.network.EzySearchApiService
import com.example.ezysearch.network.KEY
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class SearchScreenViewModel @Inject constructor(private val retrofit: EzySearchApiService) : ViewModel() {

   var stringStates by mutableStateOf(StringStates())
    private set

    var ezySearchUiState: EzySearchUiState by mutableStateOf(EzySearchUiState.Start)
    private set

    var pageList: List<Page> = mutableListOf()

   fun updateSearchField(search: String) {
       stringStates = stringStates.copy(searchText = search)
   }
   fun resetEzySearUiState() {
       ezySearchUiState = EzySearchUiState.Start
   }

   fun onTextCleared() {
       stringStates = stringStates.copy(searchText = "")
   }

    fun getSearchResults() {
            ezySearchUiState = EzySearchUiState.Loading
            viewModelScope.launch {
                try {
                    val jsonString = retrofit.getSearchResult(key = KEY, cx = CX, q = stringStates.searchText)
                    val networkResult = Gson().fromJson(jsonString, PagesModelClass::class.java)
                    val pageArrayList = networkResult.items
                    pageList = pageArrayList.toList()
                    //stringStates = stringStates.copy(networkResult = pageArrayList[0].link)
                    ezySearchUiState = EzySearchUiState.Success
                } catch(e: IOException) {
                    ezySearchUiState = EzySearchUiState.Error
                }
            }
    }

}