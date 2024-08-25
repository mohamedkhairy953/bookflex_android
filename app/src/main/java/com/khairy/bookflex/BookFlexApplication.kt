package com.khairy.bookflex

import android.app.Application
import android.util.Log
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.internal.Contexts.getApplication


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
        AppCenter.start(
            this, "0d235036-66eb-4eb2-a90c-8078b9ab0777",
            Analytics::class.java,
            Crashes::class.java
        )
    }
}
