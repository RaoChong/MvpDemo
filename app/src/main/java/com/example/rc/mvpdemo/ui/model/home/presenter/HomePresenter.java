package com.example.rc.mvpdemo.ui.model.home.presenter;

import com.example.rc.mvpdemo.model.biz.UserModel;
import com.example.rc.mvpdemo.model.callback.NetworkCallback;
import com.example.rc.mvpdemo.model.entity.StudentBean;
import com.example.rc.mvpdemo.ui.model.home.contract.HomeContract;

public class HomePresenter implements HomeContract.Presenter {

    private UserModel model;
    private HomeContract.View mView;

    public HomePresenter() {
        model = new UserModel();
    }

    @Override
    public void getNewsList() {
        model.newsList(new NetworkCallback<StudentBean>() {
            @Override
            public void onSuccess(StudentBean studentBean) {
                if (mView != null) {
                    mView.showNewsList(studentBean);
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void attach(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void decath() {
        this.mView = null;
    }
}
