package com.example.rc.mvpdemo.model.http;

public class HttpFactory {

    public static IHtttp create(){
        return OkHttpUtils.getInstance();
    }
}
