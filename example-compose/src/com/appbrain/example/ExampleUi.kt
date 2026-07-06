package com.appbrain.example

import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/** Wraps [content] in the app's Material 3 theme and a full-screen surface. */
fun ComponentActivity.setExampleContent(content: @Composable () -> Unit) {
    enableEdgeToEdge()
    setContent {
        MaterialTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                // Keep content clear of the status and navigation bars (the app
                // draws edge-to-edge on Android 15+).
                Box(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
                    content()
                }
            }
        }
    }
}

/** Shows a short (or long) toast. */
fun Context.toast(message: String, longDuration: Boolean = false) {
    val duration = if (longDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
    Toast.makeText(this, message, duration).show()
}
