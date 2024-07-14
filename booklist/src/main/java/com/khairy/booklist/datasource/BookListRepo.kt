package com.khairy.booklist.datasource

import com.khairy.enitities.BookEntity

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