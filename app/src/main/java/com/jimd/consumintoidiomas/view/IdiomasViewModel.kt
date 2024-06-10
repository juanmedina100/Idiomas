package com.jimd.consumintoidiomas.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.consumintoidiomas.domain.Repositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IdiomasViewModel @Inject constructor(
    private val repositorio: Repositorio
):ViewModel(){

    var state by mutableStateOf(IdiomaState())

    fun getAllIdiomas(){
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch(Dispatchers.IO) {
            state = state.copy(
                idiomas = repositorio.getAllIdiomas(),
                isLoading = false
            )
        }
    }
}