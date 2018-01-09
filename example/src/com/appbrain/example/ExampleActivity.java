package com.appbrain.example;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.appbrain.AdId;
import com.appbrain.AdService;
import com.appbrain.AppBrain;
import com.appbrain.AppBrainUserData;
import com.appbrain.AppBrainUserData.Gender;
import com.appbrain.InterstitialBuilder;
import com.appbrain.InterstitialListener;
import com.appbrain.RemoteSettings;

public class ExampleActivity extends Activity {
    private InterstitialBuilder builder;
    private InterstitialBuilder exitInterstitialBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppBrain.init(this);
        // Say we know here that the user is male and is 35 years old, then we can pass this to AppBrain:
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, -35);

        AppBrain.getAds().setUserData(AppBrainUserData.create().setGender(Gender.MALE).setBirthDate(
            calendar.getTime()));

        setContentView(R.layout.main);

        final RemoteSettings settings = AppBrain.getSettings();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // fetch the welcome message from the remote settings
                String welcomeMessage = settings.get("welcome_message",
                    "Hello (this comes from the app)");
                // show as toast
                Toast.makeText(ExampleActivity.this, welcomeMessage, Toast.LENGTH_LONG).show();
            }
        }, 2500);

        final InterstitialListener listener = new InterstitialListener() {
            @Override
            public void onPresented() {
                Toast.makeText(ExampleActivity.this,
                    "Interstitial presented", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDismissed(boolean wasClicked) {
                Toast.makeText(ExampleActivity.this,
                    "Interstitial dismissed, clicked: " + wasClicked, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLoaded() {
                Toast.makeText(ExampleActivity.this,
                    "Ad successfully loaded!", Toast.LENGTH_SHORT).show();
                // If we want to show as soon as possible we would call
                // builder.show(ExampleActivity.this);
                // here.
            }

            @Override
            public void onAdFailedToLoad(InterstitialError interstitialError) {
                Toast.makeText(ExampleActivity.this,
                    "Ad failed to load: " + interstitialError, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClick() {
                Toast.makeText(ExampleActivity.this,
                    "Interstitial clicked", Toast.LENGTH_SHORT).show();
            }
        };

        builder = InterstitialBuilder.create().setListener(listener).
            setAdId(AdId.HOME_SCREEN).preload(this);

        exitInterstitialBuilder = InterstitialBuilder.create().setAdId(AdId.EXIT);
        exitInterstitialBuilder.setOnDoneCallback(new Runnable(){
            @Override
            public void run() {
                ExampleActivity.this.finish();
            }
        });
        exitInterstitialBuilder.preload(this);

        final AdService ads = AppBrain.getAds();
        findViewById(R.id.maybe_show_interstitial).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                InterstitialBuilder builder = InterstitialBuilder.create();
                if (!builder.maybeShow(ExampleActivity.this)) {
                    Toast.makeText(ExampleActivity.this,
                        "not showing, since it was shown already recently", Toast.LENGTH_LONG).show();
                } else {
                    // Preload the builder again
                    builder.preload(ExampleActivity.this);
                }
            }
        });
        findViewById(R.id.show_interstitial).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!builder.show(ExampleActivity.this)) {
                    Toast.makeText(ExampleActivity.this,
                        "Not showing, no internet connection?", Toast.LENGTH_LONG).show();
                } else {
                    // Preload the builder again
                    builder.preload(ExampleActivity.this);
                }
            }
        });

        ads.setOfferWallClickListener(this, findViewById(R.id.show_offerwall));

        findViewById(R.id.show_banners).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(ExampleActivity.this, BannerActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.show_listview).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExampleActivity.this, ListAdsActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        exitInterstitialBuilder.show(ExampleActivity.this);
    }
}
