package com.jimd.consumintoidiomas.di

import com.jimd.consumintoidiomas.data.ApiService
import com.jimd.consumintoidiomas.data.Constantes.Companion.URL_BASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    val timeout = 10L // Tiempo de espera en segundo

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)

            //.addInterceptor(IpInterceptor())
            .callTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .build()
    }


    @Singleton
    @Provides
    fun provideretrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
            .build()
    }
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    //Injectamos DataStore
//    @Singleton
//    @Provides
//    fun providePreferencesDataStore(@ApplicationContext context: Context):DataStore<Preferences> =
//        PreferenceDataStoreFactory.create {
//            context.preferencesDataStoreFile(DATA_STORE_NAME)
//        }
}