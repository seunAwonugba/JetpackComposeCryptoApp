package com.example.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.base.view.AllCoinsResponse

@Composable
fun AllCoinsListItem(
    allCoinsResponse : AllCoinsResponse,
    onClickListItem : (AllCoinsResponse) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onClickListItem(allCoinsResponse) }
            .fillMaxSize()
            .padding(16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "${allCoinsResponse.rank}. ${allCoinsResponse.name} (${allCoinsResponse.symbol})",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


            if (allCoinsResponse.is_active){
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


}