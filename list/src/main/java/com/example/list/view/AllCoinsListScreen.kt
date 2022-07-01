package com.example.list.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.list.AllCoinsViewModel
import com.example.list.components.AllCoinsListItem

@Composable
fun AllCoinsListScreen(
    viewModel : AllCoinsViewModel = hiltViewModel(),
    navToDetails : (String) -> Unit
) {
    val state = viewModel.state.value
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = "Crypto Coins")
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()){
            when{
                state.isLoading -> {
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressIndicator()
                    }
                }

                state.error.isNotEmpty() -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "An error occurred, caused by : ${state.error}",
                            textAlign = TextAlign.Justify,
                            color = Color.Red
                        )

                    }
                }

                else -> {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.fetchedCoins){ item ->
                            AllCoinsListItem(allCoinsResponse = item){
                                navToDetails(item.id)
                            }
                        }
                    }
                }
            }
        }
    }

    
}