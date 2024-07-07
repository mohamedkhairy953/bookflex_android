package com.khairy.booklist.datasource

import com.khairy.booklist.datasource.cache.BookListDao
import com.khairy.booklist.datasource.cache.entity.BookEntity
import com.khairy.booklist.datasource.remote.BookListService
import com.khairy.booklist.mappers.BookDtoToEntityMapper
import com.khairy.booklist.model.BookModel

class BookListRepoImpl(
    private val bookListService: BookListService,
    private val bookListDao: BookListDao,
    private val bookDtoToEntityMapper: BookDtoToEntityMapper
) : BookListRepo {

    /**
     * get books from remote and save them in the local database
     * @return list of books
     */
    override suspend fun getBooks(): List<BookEntity> {
        val books = bookListService.getBooks()
        val bookEntities = books.map { bookDtoToEntityMapper.map(it) }
        bookListDao.insertBooks(bookEntities)
        return bookListDao.getAllBooks()
    }
}