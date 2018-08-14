package com.example.mvpdemo2.ui.home.contract;

import com.example.mvpdemo2.base.BasePresenter;
import com.example.mvpdemo2.base.BaseView;
import com.example.mvpdemo2.model.entity.InfoBean;

public interface HomeContreact {

    interface View extends BaseView{
        void infoShow(InfoBean bean);
    }

    interface Presenter extends BasePresenter<View>{
        void infoData(String type,String key);
    }

}
