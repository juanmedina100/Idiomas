package com.jimd.consumintoidiomas.view

import com.jimd.consumintoidiomas.data.dto.Idioma

data class IdiomaState(
//    val idioma:String = "",
//    val codigo:String = "",
    val idiomas:List<Idioma> = emptyList(),
    val isLoading:Boolean = false
)
