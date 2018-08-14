package com.example.retrofitdemo.ui.model.home.contract;

import com.example.retrofitdemo.base.BasePresenter;
import com.example.retrofitdemo.base.BaseView;
import com.example.retrofitdemo.model.entity.InfoBean;

public interface HomeContract {
    interface View extends BaseView {
        void infoShow(InfoBean bean);
    }

    interface Presenter extends BasePresenter<View> {
        void infoData(String url);
    }
}
