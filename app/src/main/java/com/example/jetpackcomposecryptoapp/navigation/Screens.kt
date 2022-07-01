package com.example.jetpackcomposecryptoapp.navigation

sealed class Screens(val route : String){
    object AllCoinsScreen : Screens("all_coins_list_screen")
    object SingleCoinScreen : Screens("single_coin_screen")
}
