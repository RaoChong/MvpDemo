package com.example.rc.mvpdemo.model.biz;

import com.example.rc.mvpdemo.config.Urls;
import com.example.rc.mvpdemo.model.callback.NetworkCallback;
import com.example.rc.mvpdemo.model.entity.StudentBean;
import com.example.rc.mvpdemo.model.http.HttpFactory;

public class UserModel implements IUserModel {

    @Override
    public void newsList(NetworkCallback<StudentBean> callback) {
        HttpFactory.create().doGet(Urls.NEWSLIST,callback);
    }
}
