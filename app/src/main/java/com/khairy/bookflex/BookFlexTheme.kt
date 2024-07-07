package com.khairy.bookflex

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun BookFlexTheme(content: @Composable () -> Unit) {

    CompositionLocalProvider() {
        MaterialTheme(
            content = content
        )
    }
}