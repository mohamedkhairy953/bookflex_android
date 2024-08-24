package com.khairy.bookdetails.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.khairy.bookdetails.datasource.BookDetailsRepo
import com.khairy.booklist.mappers.BookEntityToModelMapper
import com.khairy.booklist.model.BookModel
import javax.inject.Inject

class FetchBookDetailsUseCase @Inject constructor(
    private val repo: BookDetailsRepo,
    private val bookEntityToModelMapper: BookEntityToModelMapper
) {
    operator fun invoke(title:String): LiveData<BookModel> {
        return repo.getBookDetails(title).map { bookEntityToModelMapper.map(it) }
    }
}
