package com.example.rc.mvpdemo.ui.model.home.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rc.mvpdemo.R;
import com.example.rc.mvpdemo.model.entity.StudentBean;
import com.example.rc.mvpdemo.ui.model.home.contract.HomeContract;
import com.example.rc.mvpdemo.ui.model.home.presenter.HomePresenter;

public class MainActivity extends AppCompatActivity implements HomeContract.View{

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homePresenter = new HomePresenter();
        homePresenter.attach(this);
        homePresenter.getNewsList();
    }

    @Override
    public void showNewsList(StudentBean bean) {
        Toast.makeText(this, bean.getResult().getData().get(1).getAuthor_name(), Toast.LENGTH_SHORT).show();
    }
}
