package com.example.ezysearch.screens.searchscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ezysearch.R
import com.example.ezysearch.model.EzySearchUiState
import com.example.ezysearch.screens.editedScreens.ModifiedMyTextField

@Composable
fun SearchScreen(
                 searchText: String,
                 onValueChange: (String) -> Unit,
                 onTextCleared: () -> Unit,
                 onGoButtonClicked: () -> Unit,
                 navigateToPages: ()-> Unit,
                 ezySearchUiState: EzySearchUiState,
                 modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        Box(modifier = Modifier.fillMaxSize().align(Alignment.TopCenter),
            contentAlignment = Alignment.Center)
        {
            Column(modifier = modifier.fillMaxSize().padding(top = 160.dp)
                .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        painter = painterResource(id = R.drawable.search_thick),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp).padding(top = 8.dp, start = 3.dp),
                        tint = MaterialTheme.colors.secondary
                    )
                    Text(text = stringResource(R.string.search_string),
                        modifier = Modifier.padding(bottom = 12.dp, start = 3.dp),
                        color = MaterialTheme.colors.primary,
                        style = MaterialTheme.typography.h2)
                }
                Spacer(modifier = Modifier.height(24.dp))
                Surface(shape = RoundedCornerShape(50.dp), elevation = 6.dp,
                    modifier = Modifier.padding(horizontal = 30.dp)) {
                    ModifiedMyTextField(search = searchText,
                        onValueChange = { onValueChange(it) }, onCleared = { onTextCleared() })
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(modifier = Modifier.align(Alignment.End).padding(end = 35.dp)
                    .height(30.dp).width(50.dp),
                    contentPadding = PaddingValues(0.dp),
                    onClick = {
                        if(searchText != ""){ onGoButtonClicked()}
                    },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.onPrimary
                    )){
                    Text(text = stringResource(R.string.go), style = MaterialTheme.typography.h3)
                }
                SearchScreenStates(uiState = ezySearchUiState, navParameter = navigateToPages)
            }
        }
        Text(text = stringResource(R.string.creator),
            style = TextStyle(fontSize = 10.sp, color = MaterialTheme.colors.onSurface,
                fontFamily = FontFamily.Cursive),
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 4.dp))
    }
}


/** @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EzySearchTheme {
        SearchScreen(navigateToPages = {})
    }
}
*/