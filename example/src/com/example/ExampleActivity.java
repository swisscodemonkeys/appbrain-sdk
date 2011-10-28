package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.appbrain.AdService;
import com.appbrain.AppBrain;
import com.appbrain.RemoteSettings;
import com.example.fun.LogoView;

public class ExampleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppBrain.init(this);
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

        
        final AdService ads = AppBrain.getAds();
        findViewById(R.id.show_interstitial).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!ads.maybeShowInterstitial(ExampleActivity.this)) {
                    Toast.makeText(ExampleActivity.this,
                        "not showing, since it was shown already recently", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.show_offerwall).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ads.showOfferWall(ExampleActivity.this);
            }
        });

        
        findViewById(R.id.show_popup).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                ads.showDialog(ExampleActivity.this, "Hello", "This is an example", "Ok", new Runnable() {

                    @Override
                    public void run() {
                        Toast.makeText(ExampleActivity.this, "You selected 'Ok'", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    // @Override
    public void onBackPressed() {
        AppBrain.getAds().maybeShowInterstitial(this);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (android.os.Build.VERSION.SDK_INT < 5 && keyCode == KeyEvent.KEYCODE_BACK
            && event.getRepeatCount() == 0) {
            // Take care of calling this method on earlier versions of
            // the platform where it doesn't exist.
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }
}