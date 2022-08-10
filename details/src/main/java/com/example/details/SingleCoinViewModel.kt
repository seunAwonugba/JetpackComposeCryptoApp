package com.example.details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.usecase.GetSingleCoinUseCase
import com.example.base.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SingleCoinViewModel @Inject constructor(
    private val singleCoinUseCase: GetSingleCoinUseCase,
    //save state handle contains nav args parameter, so we can access it in our VM directly
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(SingleCoinState())
    val state : State<SingleCoinState> = _state

    private val coinId: String?
        get() = savedStateHandle["coinId"]


    init {
        getSingleCoin(coinId = coinId.toString())
    }

    private fun getSingleCoin(coinId : String){
        singleCoinUseCase(coinId = coinId).onEach {
            when(it){
                is Resource.Success -> {
                    val data = it.data
                    if (data != null){
                        _state.value = SingleCoinState(fetchedCoins = data)
                    }
                }
                is Resource.Error -> {
                    _state.value = SingleCoinState(error = it.message.toString())
                    Log.e("MY_ERROR", it.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = SingleCoinState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}