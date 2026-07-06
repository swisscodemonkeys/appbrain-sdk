package com.appbrain.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

import com.appbrain.AdId
import com.appbrain.AppBrainBanner
import com.appbrain.BannerListener

class BannerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setExampleContent {
            BannerScreen()
        }
    }

    @Composable
    private fun BannerScreen() {
        val context = LocalContext.current

        var titleIndex by remember { mutableIntStateOf(0) }
        var buttonIndex by remember { mutableIntStateOf(0) }
        var designIndex by remember { mutableIntStateOf(0) }
        var colorIndex by remember { mutableIntStateOf(0) }

        val titles = remember { List(TITLE_COUNT) { "Title $it" } }
        val buttons = remember { List(BUTTON_TEXT_COUNT) { "Button $it" } }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("AppBrain banner playground", style = MaterialTheme.typography.titleLarge)

            Selector("Title", titles, titleIndex) { titleIndex = it }
            Selector("Button", buttons, buttonIndex) { buttonIndex = it }
            Selector("Design", DESIGN_NAMES, designIndex) { designIndex = it }
            Selector("Colors", COLOR_NAMES, colorIndex) { colorIndex = it }

            Box(modifier = Modifier.weight(1f))

            // Recreate the banner whenever a selection changes.
            key(titleIndex, buttonIndex, designIndex, colorIndex) {
                AndroidView(
                    modifier = Modifier.fillMaxWidth(),
                    factory = { ctx ->
                        AppBrainBanner(ctx).apply {
                            setBannerListener(object : BannerListener {
                                override fun onAdRequestDone(hasAd: Boolean) {
                                    // Ignore
                                }

                                override fun onClick() {
                                    context.toast("Banner clicked!")
                                }
                            })
                            setAdId(AdId.DEFAULT)
                            setSize(AppBrainBanner.BannerSize.RESPONSIVE)
                            setTitleIndex(titleIndex)
                            setButtonTextIndex(buttonIndex)
                            setDesign(designIndex)
                            setColors(colorIndex)
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun Selector(
        label: String,
        options: List<String>,
        selectedIndex: Int,
        onSelected: (Int) -> Unit
    ) {
        var expanded by remember { mutableStateOf(false) }
        Box {
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("$label: ${options[selectedIndex]}")
            }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEachIndexed { index, option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            onSelected(index)
                            expanded = false
                        })
                }
            }
        }
    }

    companion object {
        private val COLOR_NAMES = listOf(
            "0, Dark and blue",
            "1, Light and blue",
            "2, Light design",
            "3, Dark and blue",
            "4, Blue and orange",
            "5, White and green",
            "6, Candy",
            "7, Sahara",
            "8, Red",
            "9, Green",
            "10, Blue",
            "11, Purple",
            "12, Light grey",
            "13: Light b&w")

        private val DESIGN_NAMES = listOf(
            "Simple 1",
            "Simple 2",
            "Arrows",
            "Ellipse")

        private const val TITLE_COUNT = 4
        private const val BUTTON_TEXT_COUNT = 3
    }
}
