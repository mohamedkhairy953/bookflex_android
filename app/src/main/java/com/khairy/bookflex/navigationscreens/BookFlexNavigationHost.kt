package com.khairy.bookflex.navigationscreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.khairy.bookdetails.ui.BookDetailsScreen
import com.khairy.booklist.ui.BookListScreen
import com.khairy.navigation.DetailScreen
import com.khairy.navigation.ListScreen

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 9/1/2024 3:51 PM
 */

@Composable
fun BookFlexNavigationHost(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = ListScreen
    ) {
        composable<ListScreen> {
            BookListScreen(navController = navController)
        }
        composable<DetailScreen> {
            val detailScreen = it.toRoute<DetailScreen>()
            BookDetailsScreen(
                bookTitle = detailScreen.bookTitle
            )
        }
    }
}