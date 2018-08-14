package com.example.mvpdemo2.model.network;

import com.example.mvpdemo2.config.Urls;
import com.example.mvpdemo2.model.biz.HomeService;

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
    private final Retrofit retrofit;
    private OkHttpClient okHttpClient;

    private RetrofitUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        //拦截器 拦截请求request
                        Request build = chain.request().newBuilder().build();
                        return chain.proceed(build);
                    }
                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RetrofitUtils getInstance(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public HomeService getApi(){
        return retrofit.create(HomeService.class);
    }
}
