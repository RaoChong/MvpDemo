package com.example.rc.mvpdemo.model.biz;


import com.example.rc.mvpdemo.model.callback.NetworkCallback;
import com.example.rc.mvpdemo.model.entity.StudentBean;

public interface IUserModel {

   void newsList(NetworkCallback<StudentBean> callback);

}
