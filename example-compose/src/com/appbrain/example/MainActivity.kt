package com.appbrain.example

import java.util.Calendar
import java.util.GregorianCalendar

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import kotlinx.coroutines.delay

import com.appbrain.AdId
import com.appbrain.AppBrain
import com.appbrain.AppBrainBanner
import com.appbrain.AppBrainUserData
import com.appbrain.InterstitialBuilder
import com.appbrain.InterstitialListener
import com.appbrain.example.logo.LogoView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppBrain.init(this)

        // Say we know here that the user is male and is 35 years old, then we can pass this to AppBrain:
        val calendar = GregorianCalendar()
        calendar.add(Calendar.YEAR, -35)
        AppBrain.getAds().setUserData(
            AppBrainUserData.create()
                .setGender(AppBrainUserData.Gender.MALE)
                .setBirthDate(calendar.time))

        setExampleContent {
            MainScreen()
        }
    }
}

@Composable
private fun MainScreen() {
    val context = LocalContext.current

    val listener = remember {
        object : InterstitialListener {
            override fun onPresented() = context.toast("Interstitial presented")
            override fun onDismissed(wasClicked: Boolean) = context.toast("Interstitial dismissed, clicked: $wasClicked")
            override fun onAdLoaded() = context.toast("Ad successfully loaded!")
            override fun onAdFailedToLoad(error: InterstitialListener.InterstitialError) = context.toast("Ad failed to load: $error")
            override fun onClick() = context.toast("Interstitial clicked")
        }
    }
    val homeInterstitial = remember {
        InterstitialBuilder.create().setListener(listener).setAdId(AdId.HOME_SCREEN)
    }
    val exitInterstitial = remember {
        InterstitialBuilder.create().setAdId(AdId.EXIT).setOnDoneCallback {
            (context as? ComponentActivity)?.finish()
        }
    }

    // Preload both interstitials once, when the screen first appears.
    LaunchedEffect(Unit) {
        homeInterstitial.preload(context)
        exitInterstitial.preload(context)
    }

    // Show the welcome message from the remote settings shortly after startup.
    LaunchedEffect(Unit) {
        delay(2500)
        val welcomeMessage = AppBrain.getSettings()
            .get("welcome_message", "Hello (this comes from the app)")
        context.toast(welcomeMessage, longDuration = true)
    }

    // Show the exit interstitial when the user presses back.
    BackHandler { exitInterstitial.show(context) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogoView(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            ExampleButton("Maybe Show Interstitial") {
                // maybeShow() intentionally uses a fresh, un-preloaded builder: it only
                // shows if enough time has passed since the last interstitial, so there
                // is no point pre-loading one that might not be shown.
                val builder = InterstitialBuilder.create()
                if (!builder.maybeShow(context)) {
                    context.toast("not showing, since it was shown already recently")
                } else {
                    builder.preload(context)
                }
            }
            ExampleButton("Show Interstitial") {
                if (!homeInterstitial.show(context)) {
                    context.toast("Not showing, no internet connection?")
                } else {
                    homeInterstitial.preload(context)
                }
            }
            ExampleButton("Show Offerwall") {
                AppBrain.getAds().showOfferWall(context)
            }
            ExampleButton("Banner playground") {
                context.startActivity(Intent(context, BannerActivity::class.java))
            }
            ExampleButton("ListView example") {
                context.startActivity(Intent(context, ListAdsActivity::class.java))
            }
        }

        // A banner anchored to the bottom of the screen, using the classic
        // AppBrainBanner view through Compose's AndroidView interop.
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = { ctx ->
                AppBrainBanner(ctx).apply {
                    setAdId(AdId.DEFAULT)
                    setColors(12)
                }
            }
        )
    }
}

@Composable
private fun ExampleButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.width(220.dp)
    ) {
        Text(text)
    }
}
