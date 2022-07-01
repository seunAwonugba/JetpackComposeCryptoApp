package com.example.list.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.list.AllCoinsViewModel
import com.example.list.components.AllCoinsListItem

@Composable
fun AllCoinsListScreen(
    viewModel : AllCoinsViewModel = hiltViewModel(),
    navToDetails : () -> Unit
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.fetchedCoins){ item ->
                AllCoinsListItem(allCoinsResponse = item){
                    navToDetails()

                }

            }

        }
    }

    
}