package com.example.retrofitdemo.model.http;

import com.example.retrofitdemo.config.ApiService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitUtils() {
        okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //拦截器 拦截请求 Request
                Request request = chain.request().newBuilder().build();
                return chain.proceed(request);
            }
        }).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null)
                    retrofitUtils = new RetrofitUtils();
            }
        }
        return retrofitUtils;
    }

    public ApiService getApi() {
        return retrofit.create(ApiService.class);
    }

}

