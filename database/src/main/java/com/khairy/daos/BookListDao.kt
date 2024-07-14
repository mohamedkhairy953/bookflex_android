package com.khairy.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.khairy.enitities.BookEntity

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 7/7/2024 3:20 PM
 */
@Dao
interface BookListDao {

    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<BookEntity>

    @Insert
    suspend fun insertBooks(books: List<BookEntity>)


}