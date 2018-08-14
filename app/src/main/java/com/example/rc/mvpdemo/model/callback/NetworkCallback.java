package com.example.rc.mvpdemo.model.callback;

public interface NetworkCallback<T> {

    void onSuccess(T t);
    void onError(String errorMsg);
}
