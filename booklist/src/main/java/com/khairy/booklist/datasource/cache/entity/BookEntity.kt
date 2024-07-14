package com.khairy.booklist.datasource.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val pk: Int = 1,
    val size: Long,
    val title: String,
    val author: String,
)