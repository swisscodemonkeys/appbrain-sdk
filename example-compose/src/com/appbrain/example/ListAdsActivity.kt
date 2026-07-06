package com.appbrain.example

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

import com.appbrain.AppBrain

class ListAdsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setExampleContent {
            ListAdsScreen()
        }
    }

    @Composable
    private fun ListAdsScreen() {
        // wrapListAdapter works with the classic ListView/ListAdapter, so we host
        // a ListView through Compose's AndroidView interop.
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                val adapter = ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1)
                for (i in 0 until 100) {
                    adapter.add("Item $i")
                }

                val adAdapter = AppBrain.getAds().wrapListAdapter(ctx, adapter)
                ListView(ctx).apply {
                    setAdapter(adAdapter)
                    setOnItemClickListener { _, _, position, _ ->
                        val itemPosition = adAdapter.getItemPosition(position)
                        ctx.toast("Item $itemPosition pressed")
                    }
                }
            }
        )
    }
}
