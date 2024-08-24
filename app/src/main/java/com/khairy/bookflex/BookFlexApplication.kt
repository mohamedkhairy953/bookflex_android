package com.khairy.bookflex

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 5/16/2024 9:32 PM
 */
@HiltAndroidApp
class BookFlexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreate: ")
    }
}
