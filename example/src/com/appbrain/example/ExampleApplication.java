package com.appbrain.example;

import android.app.Application;

import com.appbrain.AppBrain;

public class ExampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppBrain.initApp(this);
    }
}
