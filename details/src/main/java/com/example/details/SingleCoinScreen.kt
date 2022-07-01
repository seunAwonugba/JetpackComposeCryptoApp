package com.example.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SingleCoinScreen(
    viewModel: SingleCoinViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    when{
        state.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        state.error.isNotEmpty() -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = state.error,
                    textAlign = TextAlign.Justify,
                    color = Color.Red
                )

            }

        }

        else -> {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)) {
                LazyColumn(modifier = Modifier.fillMaxSize()){

                    item {
                        Box(modifier = Modifier.fillMaxWidth()){
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "${state.fetchedCoins?.rank} ${state.fetchedCoins?.name} (${state.fetchedCoins?.symbol})"
                                )

                                if (state.fetchedCoins?.is_active == true){
                                    Text(
                                        text = "active",
                                        color = MaterialTheme.colors.primary,
                                        fontStyle = FontStyle.Italic
                                    )
                                }else{
                                    Text(
                                        text = "in-active",
                                        color = Color.Red,
                                        fontStyle = FontStyle.Italic
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Box(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "${state.fetchedCoins?.description}",
                                textAlign = TextAlign.Justify
                            )
                        }
                    }

                }
            }
        }
    }
    
}