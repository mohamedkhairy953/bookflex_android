package com.khairy.bookflex

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.khairy.bookflex.navigationscreens.BookFlexNavigationHost
import com.khairy.booklist.viewmodel.BookListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val bookListViewModel: BookListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BookFlexTheme {
                BookFlexNavigationHost(
                    navController = navController,
                )
            }
        }
    }

}