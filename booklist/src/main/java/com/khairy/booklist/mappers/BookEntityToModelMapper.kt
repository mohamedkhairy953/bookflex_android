package com.khairy.booklist.mappers

import com.khairy.booklist.datasource.cache.entity.BookEntity
import com.khairy.booklist.datasource.model.response.BookDto
import com.khairy.booklist.model.BookModel

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 7/7/2024 3:33 PM
 */
class BookEntityToModelMapper {
    fun map(bookDto: BookEntity): BookModel {
        return BookModel(
            size = bookDto.size,
            title = bookDto.title,
            author = bookDto.author
        )
    }
}