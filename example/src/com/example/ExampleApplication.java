package com.example;

import android.app.Application;

import com.appbrain.ads.AdUtil;

public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AdUtil.init(this);
    }
}
