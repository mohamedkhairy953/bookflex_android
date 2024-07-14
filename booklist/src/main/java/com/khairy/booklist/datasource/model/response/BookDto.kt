package com.khairy.booklist.datasource.model.response

import androidx.annotation.Keep

@Keep
data class BookDto(
    val size: Long,
    val title: String,
    val author: String
)