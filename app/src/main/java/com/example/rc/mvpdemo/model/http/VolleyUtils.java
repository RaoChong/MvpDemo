package com.example.rc.mvpdemo.model.http;

import android.widget.ImageView;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.rc.mvpdemo.model.callback.NetworkCallback;
import com.example.rc.mvpdemo.utils.SUtils;

import java.io.File;
import java.util.Map;

import okhttp3.OkHttpClient;

public class VolleyUtils implements IHtttp {

    private static VolleyUtils volleyUtils;
    private RequestQueue queue;
    private VolleyUtils(){
        queue = Volley.newRequestQueue(SUtils.getApp());
    }

    public static VolleyUtils getInstance(){
        if (volleyUtils == null){
            synchronized (OkHttpUtils.class){
                if (volleyUtils == null)
                    volleyUtils = new VolleyUtils();
            }
        }
        return volleyUtils;
    }
    @Override
    public <T> void doGet(String url, NetworkCallback<T> callback) {

    }

    @Override
    public <T> void doGet(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public <T> void doPost(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public void upload(String url, Map<String, File> files, Map<String, String> params, NetworkCallback<String> callback) {

    }

    @Override
    public void download() {

    }

    @Override
    public void loadImage(String url, ImageView view) {

    }
}
