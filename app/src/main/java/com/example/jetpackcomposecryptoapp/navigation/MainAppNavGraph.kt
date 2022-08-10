package com.example.jetpackcomposecryptoapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.details.SingleCoinScreen
import com.example.list.view.AllCoinsListScreen

@Composable
fun MainAppNavGraph(
    navController: NavHostController,
    onTitleChange: (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screens.AllCoinsScreen.route
    ){
        composable(Screens.AllCoinsScreen.route){
            AllCoinsListScreen { args->
                navController.navigate("${Screens.SingleCoinScreen.route}/$args")
            }
        }

        //id was of the args was passed using saveStateHandler in VM, instead of using args
        composable("${Screens.SingleCoinScreen.route}/{coinId}"){
            onTitleChange("Crypto Details")
            SingleCoinScreen()

        }

    }

}