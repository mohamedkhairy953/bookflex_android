package com.khairy.bookdetails.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khairy.bookdetails.usecase.DownloadBookUseCase
import com.khairy.bookdetails.usecase.FetchBookDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 8/17/2024 6:44 PM
 */
@HiltViewModel
class BookDetailsViewModel @Inject constructor(
    private val fetchBookDetailsUseCase: FetchBookDetailsUseCase,
    private val downloadBookUseCase: DownloadBookUseCase,
) : ViewModel() {

    val LOG_TAG = "BookDetailsViewModel"

    sealed class DownloadState {
        data class Success(val body: ResponseBody) : DownloadState()
        object Idle : DownloadState()
        object Loading : DownloadState()
        data class Error(val message: String) : DownloadState()
    }

    // Download state
    private val _downloadState = MutableStateFlow<DownloadState>(DownloadState.Idle)
    val downloadState: StateFlow<DownloadState> = _downloadState


    fun fetchBookDetails(title: String) = fetchBookDetailsUseCase(title)

    fun downloadBook(title: String) {
        viewModelScope.launch {
            _downloadState.update { DownloadState.Loading }
            try {
                val response = downloadBookUseCase.invoke(title)
                if (response.isSuccessful) {
                    response.body()?.let { body ->
                        _downloadState.update { DownloadState.Success(body) }
                    }
                } else {
                    _downloadState.update { DownloadState.Error("Failed to download") }
                }
            } catch (e: Exception) {
                Log.e(LOG_TAG, "downloadBook: ${e.message}")
                _downloadState.update { DownloadState.Error("Failed to download") }
            }
        }
    }
}