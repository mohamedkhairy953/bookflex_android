package com.khairy.bookdetails.datasource

import androidx.lifecycle.LiveData
import com.khairy.enitities.BookEntity
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 7/7/2024 3:28 PM
 */
interface BookDetailsRepo {
    fun getBookDetails(title: String): LiveData<BookEntity>

    suspend fun downloadBook(title: String): Response<ResponseBody>
}