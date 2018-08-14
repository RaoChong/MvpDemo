package com.example.rc.mvpdemo.ui.model.home.contract;

import com.example.rc.mvpdemo.base.BasePresenter;
import com.example.rc.mvpdemo.base.BaseView;
import com.example.rc.mvpdemo.model.entity.StudentBean;

public interface HomeContract {

    interface View extends BaseView {
        void showNewsList(StudentBean bean);
    }

    interface Presenter extends BasePresenter<View> {
        void getNewsList();
    }

}
