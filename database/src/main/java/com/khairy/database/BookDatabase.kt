// database/src/main/java/com/example/database/BookDatabase.kt

package com.khairy.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khairy.booklist.datasource.cache.BookListDao
import com.khairy.booklist.datasource.cache.entity.BookEntity

@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {

    abstract fun bookDao(): BookListDao

    companion object {
        const val DATABASE_NAME = "book_felix_database"
    }
}
