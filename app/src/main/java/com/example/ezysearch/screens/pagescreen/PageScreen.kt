package com.example.ezysearch.screens.pagescreen

import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ezysearch.model.Page
import com.example.ezysearch.model.Size
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun Pages(list:  List<Page>, resetEzySearUiState: () -> Unit, modifier: Modifier = Modifier) {
    resetEzySearUiState()
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    LazyRow(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        coroutineScope.launch {
            items(items = list, key = {item -> item.snippet}) {
                item -> WebPage(url = item.link)
            }
        }
    }
}


@Composable
fun WebPage(url: String, modifier: Modifier = Modifier) {
    val size = Size()
    val screenWidth = size.width()
    Card(modifier = modifier
        .width(screenWidth.dp)
        .verticalScroll(rememberScrollState())
        .padding(horizontal = 12.dp, vertical = 8.dp)) {
            AndroidView(modifier = Modifier.fillMaxSize(),
            factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    loadUrl(url)
                }
            }, update = { it.loadUrl(url) }
           )
    }
}




@Composable
fun Helper(){
    LaunchedEffect(Unit){}
}