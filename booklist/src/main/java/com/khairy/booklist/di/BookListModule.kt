package com.khairy.booklist.di

import com.khairy.booklist.datasource.BookListRepo
import com.khairy.booklist.datasource.BookListRepoImpl
import com.khairy.booklist.datasource.cache.BookListDao
import com.khairy.booklist.datasource.remote.BookListService
import com.khairy.booklist.mappers.BookDtoToEntityMapper
import com.khairy.booklist.mappers.BookEntityToModelMapper
import com.khairy.booklist.usecase.BookListUseCase
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
 * @since 7/7/2024 3:24 PM
 */
@InstallIn(SingletonComponent::class)
@Module
object BookListModule {

    @Provides
    fun provideBookDtoToEntityMapper(): BookDtoToEntityMapper {
        return BookDtoToEntityMapper()
    }

    @Provides
    fun provideBookListService(retrofit: Retrofit): BookListService {
        return retrofit.create(BookListService::class.java)
    }

    @Provides
    fun provideBookListRepo(
        bookListService: BookListService,
        bookDtoToEntityMapper: BookDtoToEntityMapper,
        bookListDao: BookListDao,
    ): BookListRepo {
        return BookListRepoImpl(
            bookListService = bookListService,
            bookDtoToEntityMapper = bookDtoToEntityMapper,
            bookListDao = bookListDao
        )
    }

    @Provides
    fun provideBookListUseCase(
        bookListRepo: BookListRepo,
        mapper: BookEntityToModelMapper,
    ): BookListUseCase {
        return BookListUseCase(bookListRepo, mapper)
    }

    @Provides
    fun provideBookEntityToModelMapper(): BookEntityToModelMapper {
        return BookEntityToModelMapper()
    }
}