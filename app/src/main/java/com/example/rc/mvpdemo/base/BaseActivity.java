package com.example.rc.mvpdemo.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

    }

    abstract int getLayoutId();
}
