package com.example.mvpdemo2.base;

import android.view.View;

import com.example.mvpdemo2.model.network.RetrofitUtils;

public interface BasePresenter<T>{
    void attacth(T view);

    void death();
}
