package com.khairy.booklist.usecase

import com.khairy.booklist.datasource.BookListRepo
import com.khairy.booklist.mappers.BookEntityToModelMapper
import com.khairy.booklist.model.BookModel
import javax.inject.Inject

class BookListUseCase @Inject constructor(
    private val bookListRepo: BookListRepo,
    private val bookEntityToModelMapper: BookEntityToModelMapper
) {
    suspend operator fun invoke(): List<BookModel> {
        return bookListRepo.getBooks().map { bookEntityToModelMapper.map(it) }
    }
}
