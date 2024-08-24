package com.khairy.bookdetails.datasource.remote

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface DownloadBookService {
    @GET("epub/{title}")
    @Streaming
    suspend fun downloadFile(@Path("title") title: String): Response<ResponseBody>
}