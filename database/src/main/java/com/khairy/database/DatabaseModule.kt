// database/src/main/java/com/example/database/di/DatabaseModule.kt

package com.khairy.database

import android.content.Context
import androidx.room.Room

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

}
