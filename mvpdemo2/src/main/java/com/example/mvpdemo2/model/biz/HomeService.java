package com.example.mvpdemo2.model.biz;

import com.example.mvpdemo2.config.Urls;
import com.example.mvpdemo2.model.entity.InfoBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HomeService {
    @FormUrlEncoded
    @POST(Urls.NET)
    rx.Observable<InfoBean> beans(@Field("type")String type,@Field("key")String key);
}
