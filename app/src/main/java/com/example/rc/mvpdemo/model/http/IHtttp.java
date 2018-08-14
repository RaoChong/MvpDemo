package com.example.rc.mvpdemo.model.http;

import android.widget.ImageView;


import com.example.rc.mvpdemo.model.callback.NetworkCallback;

import java.io.File;
import java.util.Map;

//网络请求的顶层接口类  做了一些约束
public interface IHtttp {

    /**
     * 无参的get请求
     * @param url 接口地址
     */
    <T> void doGet(String url, NetworkCallback<T> callback);
    //有参的get请求
    <T> void doGet(String url, Map<String, String> params, NetworkCallback<T> callback);
    //有参的post请求
    <T> void doPost(String url, Map<String, String> params, NetworkCallback<T> callback);

    void upload(String url, Map<String, File> files, Map<String, String> params, NetworkCallback<String> callback);

    void download();

    void loadImage(String url, ImageView view);


}
