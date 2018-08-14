package com.example.retrofitdemo.ui.model.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.model.entity.InfoBean;
import com.example.retrofitdemo.ui.model.home.contract.HomeContract;
import com.example.retrofitdemo.ui.model.home.presenter.HomePresenter;

public class MainActivity extends AppCompatActivity implements HomeContract.View{

    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new HomePresenter();
        presenter.attach(this);
        presenter.infoData("toutiao/index?type=&key=3819ae5d312573003994317677ce8ab8");
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels; // 屏幕宽度（像素）
        int height = metric.heightPixels; // 屏幕高度（像素）
        float density = metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi; // 屏幕密度DPI（120 / 160 / 240）
        Log.e("measure",width+"---"+height+"---"+density+"---"+densityDpi);
    }

    @Override
    public void infoShow(InfoBean bean) {
        String author_name = bean.getResult().getData().get(0).getAuthor_name();
        Log.e("author_name",author_name);
        Toast.makeText(this, author_name+"----", Toast.LENGTH_SHORT).show();
    }
}
