package com.khairy.booklist.datasource.cache.entity

import androidx.room.Entity

@Entity(tableName = "books", primaryKeys = ["id"])
data class BookEntity(
    val id: Int,
    val title: String,
    val author: String
)