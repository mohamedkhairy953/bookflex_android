package com.khairy.bookdetails.datasource

import androidx.lifecycle.LiveData
import com.khairy.bookdetails.datasource.remote.DownloadBookService
import com.khairy.booklist.mappers.BookDtoToEntityMapper
import com.khairy.daos.BookListDao
import com.khairy.enitities.BookEntity
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class BookDetailsRepoImpl @Inject constructor(
    private val downloadBookService: DownloadBookService,
    private val bookListDao: BookListDao,
) : BookDetailsRepo {
    override fun getBookDetails(title: String): LiveData<BookEntity> {
        return bookListDao.getBook(title)
    }

    override suspend fun downloadBook(title: String): Response<ResponseBody> {
        return downloadBookService.downloadFile(title)
    }
}