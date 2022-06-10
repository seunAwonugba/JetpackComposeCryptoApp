package com.example.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base.usecase.GetAllCoinsUseCase
import com.example.base.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AllCoinsViewModel @Inject constructor(
    private val getAllCoinsUseCase: GetAllCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(AllCoinsState())
    val state : State<AllCoinsState> = _state

    init {
        getAllCoins()
    }

    private fun getAllCoins(){
        getAllCoinsUseCase().onEach {
            when(it){
                is Resource.Success -> {
                    val data = it.data
                    if (data != null){
                        _state.value = AllCoinsState(fetchedCoins = data)
                    }
                }
                is Resource.Error -> {
                    _state.value = AllCoinsState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = AllCoinsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}