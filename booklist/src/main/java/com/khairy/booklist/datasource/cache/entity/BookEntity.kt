package com.khairy.booklist.datasource.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books", primaryKeys = ["id"])
data class BookEntity(
    val size: Long,
    @PrimaryKey
    val title: String,
    val author: String,
)