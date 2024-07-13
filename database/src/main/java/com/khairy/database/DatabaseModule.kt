// database/src/main/java/com/example/database/di/DatabaseModule.kt

package com.khairy.database

import android.content.Context
import androidx.room.Room
import com.khairy.booklist.datasource.cache.BookListDao

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): BookDatabase {
        return Room.databaseBuilder(
            context,
            BookDatabase::class.java,
            BookDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideBookListDao(db: BookDatabase): BookListDao {
        return db.bookDao()
    }

}
