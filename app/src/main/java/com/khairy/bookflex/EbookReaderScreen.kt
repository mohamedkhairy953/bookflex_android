package com.khairy.bookflex

import android.content.Context
import android.content.res.AssetManager
import android.net.Uri
import android.os.Environment
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import com.folioreader.FolioReader
import java.io.File
import java.io.OutputStream

@Composable
fun EbookReaderScreen(
    viewModel: EbookReaderViewModel
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.loadPdf(context, "15022024.pdf")
    }

    val folioReader: FolioReader = FolioReader.get()
    FilePicker { uri ->
        copyFileToScopedStorage(context, uri!!)?.let { path ->
            folioReader.openBook(path)
        }
    }
}

@Composable
fun FilePicker(onFileSelected: (Uri?) -> Unit) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        onFileSelected(uri)
    }

    Button(onClick = { launcher.launch("*/*") }) {
        Text("Select File")
    }
}

private fun copyFileToScopedStorage(context: Context, sourceUri: Uri): String? {
    val contentResolver = context.contentResolver
    val sourceInputStream = contentResolver.openInputStream(sourceUri)

    val sourceFileName = getFileName(context, sourceUri) ?: return null

    val destinationOutputStream: OutputStream = context.openFileOutput(sourceFileName, Context.MODE_PRIVATE)

    sourceInputStream?.use { input ->
        destinationOutputStream.use { output ->
            input.copyTo(output)
        }
    }

    return context.getFileStreamPath(sourceFileName)?.absolutePath
}

private fun getFileName(context: Context, uri: Uri): String? {
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    val nameIndex = cursor?.getColumnIndex(OpenableColumns.DISPLAY_NAME)
    cursor?.moveToFirst()
    val name = cursor?.getString(nameIndex ?: -1)
    cursor?.close()
    return name
}
