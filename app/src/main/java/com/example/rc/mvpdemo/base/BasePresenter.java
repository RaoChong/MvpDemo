package com.example.rc.mvpdemo.base;

public interface BasePresenter<V> {

    void attach(V view);
    void decath();

}
