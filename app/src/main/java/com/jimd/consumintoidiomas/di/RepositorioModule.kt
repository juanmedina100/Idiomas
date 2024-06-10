package com.jimd.consumintoidiomas.di

import com.jimd.consumintoidiomas.data.repositorio.RepositorioImpl
import com.jimd.consumintoidiomas.domain.Repositorio
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositorioModule {

    @Singleton
    @Binds
    abstract fun provideRepositorio(repositorioImpl: RepositorioImpl):Repositorio
}