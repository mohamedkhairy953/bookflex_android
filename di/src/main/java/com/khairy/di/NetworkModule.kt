// network/src/main/java/com/example/network/di/NetworkModule.kt
package com.khairy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://bookflex-305ca4bbd30f.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
