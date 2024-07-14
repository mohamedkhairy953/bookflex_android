package com.khairy.booklist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khairy.booklist.model.BookModel
import com.khairy.booklist.usecase.BookListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel @Inject constructor(
    private val getBooksUseCase: BookListUseCase,
) : ViewModel() {

    private val _bookListState = MutableStateFlow<BookListState>(BookListState.Idle)
    val bookListState: StateFlow<BookListState> = _bookListState.asStateFlow()

    fun fetchBooks() {
        _bookListState.value = BookListState.Loading
        viewModelScope.launch {
            try {
                val bookList = getBooksUseCase()
                _bookListState.value = BookListState.Success(bookList)
            } catch (e: Exception) {
                _bookListState.value = BookListState.Error(e.message ?: "An error occurred")
            }
        }
    }
}

/**
 * state of the book list screen
 */
sealed class BookListState {
    data object Loading : BookListState()
    data object Idle : BookListState()
    data class Success(val books: List<BookModel>) : BookListState()
    data class Error(val message: String) : BookListState()
}
