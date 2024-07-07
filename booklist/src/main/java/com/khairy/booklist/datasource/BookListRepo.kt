package com.khairy.booklist.datasource

import com.khairy.booklist.datasource.cache.entity.BookEntity
import com.khairy.booklist.model.BookModel

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 7/7/2024 3:28 PM
 */
interface BookListRepo {
    suspend fun getBooks(): List<BookEntity>
}