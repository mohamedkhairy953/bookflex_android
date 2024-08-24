package com.khairy.bookdetails.di

import com.khairy.bookdetails.datasource.BookDetailsRepo
import com.khairy.bookdetails.datasource.BookDetailsRepoImpl
import com.khairy.bookdetails.datasource.remote.DownloadBookService
import com.khairy.daos.BookListDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 8/17/2024 7:01 PM
 */
@Module
@InstallIn(SingletonComponent::class)
object BookDetailsModule {

    @Provides
    fun provideDownloadBookService(retrofit: Retrofit): DownloadBookService {
        return retrofit.create(DownloadBookService::class.java)
    }

    @Provides
    fun provideBookDetailsRepo(
        bookListDao: BookListDao,
        downloadBookService: DownloadBookService,
    ): BookDetailsRepo {
        return BookDetailsRepoImpl(
            bookListDao = bookListDao,
            downloadBookService = downloadBookService
        )
    }
}