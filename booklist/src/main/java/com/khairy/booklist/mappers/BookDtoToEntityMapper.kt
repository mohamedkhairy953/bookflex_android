package com.khairy.booklist.mappers

import com.khairy.enitities.BookEntity
import com.khairy.booklist.datasource.model.response.BookDto

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 7/7/2024 3:33 PM
 */
class BookDtoToEntityMapper {
    fun map(bookDto: BookDto): BookEntity {
        return BookEntity(
            size = bookDto.size,
            title = bookDto.title,
            author = bookDto.author
        )
    }
}