package com.khairy.booklist.datasource.remote

import com.khairy.booklist.datasource.model.response.BookDto
import retrofit2.http.GET

interface BookListService {
    @GET("epub/list")
    suspend fun getBooks(): List<BookDto>
}