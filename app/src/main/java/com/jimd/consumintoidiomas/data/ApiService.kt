package com.jimd.consumintoidiomas.data

import com.jimd.consumintoidiomas.data.dto.IdiomasDto
import retrofit2.http.GET


interface ApiService {

    @GET("idiomas-639-1.json")
    suspend fun getAllIdiomas():IdiomasDto

}