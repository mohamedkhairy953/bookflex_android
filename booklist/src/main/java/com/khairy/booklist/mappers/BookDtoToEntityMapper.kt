package com.khairy.booklist.mappers

import com.khairy.booklist.datasource.cache.entity.BookEntity
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
            id = bookDto.id,
            title = bookDto.title,
            author = bookDto.author
        )
    }
}