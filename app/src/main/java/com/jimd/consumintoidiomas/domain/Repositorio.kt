package com.jimd.consumintoidiomas.domain

import com.jimd.consumintoidiomas.data.dto.Idioma

interface Repositorio {

    suspend fun getAllIdiomas(): List<Idioma>

}