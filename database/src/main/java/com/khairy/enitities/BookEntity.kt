package com.khairy.enitities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    val size: Long,
    @PrimaryKey
    val title: String = "",
    val author: String,
)