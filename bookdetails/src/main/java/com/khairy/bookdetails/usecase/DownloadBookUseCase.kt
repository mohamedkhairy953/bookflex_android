package com.khairy.bookdetails.usecase

import com.khairy.bookdetails.datasource.BookDetailsRepo
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class DownloadBookUseCase @Inject constructor(
    private val repo: BookDetailsRepo
) {
    suspend operator fun invoke(title:String): Response<ResponseBody> {
        return repo.downloadBook(title)
    }
}
