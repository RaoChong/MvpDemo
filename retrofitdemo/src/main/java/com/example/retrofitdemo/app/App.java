package com.example.retrofitdemo.app;

import android.app.Application;
import android.util.DisplayMetrics;

import com.bulong.rudeness.RudenessScreenHelper;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayMetrics metric = new DisplayMetrics();
        int width = metric.widthPixels; // 屏幕宽度（像素）
        new RudenessScreenHelper(this, width).activate();
    }
}
