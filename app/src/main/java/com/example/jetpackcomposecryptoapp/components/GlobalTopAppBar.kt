package com.example.jetpackcomposecryptoapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun GlobalTopAppBar(
    title : String,
    onClickNavUp : () -> Unit
) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.Red,
        title = {
            Text(text = title)
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "navigate back",
                modifier = Modifier.clickable {
                    onClickNavUp()
                }
            )
        }
    )

}