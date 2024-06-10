package com.jimd.consumintoidiomas.data.repositorio

import com.jimd.consumintoidiomas.data.ApiService
import com.jimd.consumintoidiomas.data.dto.Idioma
import com.jimd.consumintoidiomas.domain.Repositorio
import javax.inject.Inject

class RepositorioImpl @Inject constructor(
    private val api: ApiService
):Repositorio {
    override suspend fun getAllIdiomas(): List<Idioma> {
        return api.getAllIdiomas().idiomas
    }


}