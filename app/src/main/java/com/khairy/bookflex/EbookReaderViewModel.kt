package com.khairy.bookflex

import android.content.Context
import android.graphics.pdf.PdfRenderer
import android.os.ParcelFileDescriptor
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class EbookReaderViewModel @Inject constructor() : ViewModel() {
    private val _bitmapState = mutableStateOf<android.graphics.Bitmap?>(null)
    val bitmapState = _bitmapState

    fun loadPdf(context: Context, assetFileName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val assetManager = context.assets
            val file = File(context.cacheDir, assetFileName)
            assetManager.open(assetFileName).use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

            val fileDescriptor =
                ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
            val renderer = PdfRenderer(fileDescriptor)

            val page = renderer.openPage(0)
            val bitmap = android.graphics.Bitmap.createBitmap(
                page.width,
                page.height,
                android.graphics.Bitmap.Config.ARGB_8888
            )
            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            page.close()
            renderer.close()

            _bitmapState.value = bitmap
        }
    }
}