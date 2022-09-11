package com.harunbekcan.samplejetpackcomposeproject.ui.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harunbekcan.samplejetpackcomposeproject.data.repository.CryptoRepository
import com.harunbekcan.samplejetpackcomposeproject.data.response.CryptoListResponseItem
import com.harunbekcan.samplejetpackcomposeproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListScreenViewModel @Inject constructor(private val repository: CryptoRepository):ViewModel() {

    var cryptoList = mutableStateOf<List<CryptoListResponseItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        getCryptos()
    }

    private fun getCryptos() {
        viewModelScope.launch {
            isLoading.value = true
            when(val result = repository.getCryptoList()) {
                is Resource.Success -> {
                    val cryptoItems = result.data!!.mapIndexed { _, item ->
                        CryptoListResponseItem(item.id,item.currency,item.price)
                    }

                    errorMessage.value = ""
                    isLoading.value = false
                    cryptoList.value += cryptoItems
                }
                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    isLoading.value = false
                }
                else -> {}
            }
        }
    }
}