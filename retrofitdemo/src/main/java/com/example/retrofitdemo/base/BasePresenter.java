package com.example.retrofitdemo.base;

public interface BasePresenter<V> {
    void attach(V view);

    void death();
}
