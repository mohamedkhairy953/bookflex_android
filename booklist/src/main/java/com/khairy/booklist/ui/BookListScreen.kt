package com.khairy.booklist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.khairy.booklist.model.BookModel
import com.khairy.booklist.viewmodel.BookListState
import com.khairy.booklist.viewmodel.BookListViewModel

@Composable
fun BookListScreen(viewModel: BookListViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = true) {
        viewModel.fetchBooks()
    }
    val bookListState by viewModel.bookListState.collectAsState()

    when (bookListState) {
        is BookListState.Success -> {
            BookListContent(books = (bookListState as BookListState.Success).books)
        }

        is BookListState.Error -> {
            Text(text = (bookListState as BookListState.Error).message)
        }

        is BookListState.Loading -> {
            Column {
                CircularProgressIndicator()
                Text(text = "Loading...")
            }
        }

        is BookListState.Idle -> {
            // do nothing
        }
    }
}

@Composable
private fun BookListContent(books: List<BookModel>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Book List") })
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(books.size) { index ->
                BookItem(book = books[index])
            }
        }
    }
}

@Composable
fun BookItem(book: BookModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Title: ${book.title}", style = MaterialTheme.typography.h6)
        Text(text = "Author: ${book.author}", style = MaterialTheme.typography.subtitle1)
        Text(text = "Size: ${book.size} bytes", style = MaterialTheme.typography.body2)
    }
}
