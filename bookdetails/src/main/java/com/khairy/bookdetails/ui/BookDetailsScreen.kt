package com.khairy.bookdetails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.hilt.navigation.compose.hiltViewModel
import com.khairy.bookdetails.viewmodel.BookDetailsViewModel
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 8/17/2024 7:04 PM
 */

@Composable
fun BookDetailsScreen(
    bookDetailsViewModel: BookDetailsViewModel = hiltViewModel(),
    bookTitle: String,
) {
    val bookDetails = bookDetailsViewModel.fetchBookDetails(bookTitle).observeAsState()

    val downloadState = bookDetailsViewModel.downloadState.collectAsState()
    when (val state = downloadState.value) {
        is BookDetailsViewModel.DownloadState.Success -> {
            SaveFile(state.body, bookTitle)
        }

        is BookDetailsViewModel.DownloadState.Error -> {
            Text(text = state.message)
        }

        else -> {
        }
    }
    Column {
        Text(text = bookDetails.value?.title ?: "")
        Text(text = bookDetails.value?.author ?: "")
        Text(text = bookDetails.value?.size?.toString() ?: "")

        Button(onClick = { bookDetailsViewModel.downloadBook(bookTitle) }) {
            Text(text = "Download")
        }
    }
}
@Composable
private fun SaveFile(body: ResponseBody, title: String) {
    val context = LocalContext.current
    val file = File(context.getExternalFilesDir(null), title)
    try {
        val inputStream = body.byteStream()
        val outputStream = FileOutputStream(file)
        inputStream.use { input ->
            outputStream.use { output ->
                input.copyTo(output)
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
}
