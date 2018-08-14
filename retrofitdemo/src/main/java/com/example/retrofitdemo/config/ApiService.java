package com.example.retrofitdemo.config;

import com.example.retrofitdemo.model.entity.InfoBean;

import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    rx.Observable<InfoBean> beans(@Url String src);



}
