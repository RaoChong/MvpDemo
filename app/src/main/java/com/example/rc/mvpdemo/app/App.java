package com.example.rc.mvpdemo.app;

import android.app.Application;

import com.example.rc.mvpdemo.utils.SUtils;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SUtils.initialize(this);
    }
}
