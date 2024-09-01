package com.khairy.navigation

import kotlinx.serialization.Serializable

/**
 * ...
 *
 *
 * Copyright (c) 2024 . All rights reserved.
 *
 * @author Mohamed "mohamed" Sallam.
 * @since 9/1/2024 3:43 PM
 */
@Serializable
object ListScreen

@Serializable
data class DetailScreen(val bookTitle: String)