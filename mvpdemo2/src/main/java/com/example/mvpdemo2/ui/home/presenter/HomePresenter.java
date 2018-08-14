package com.example.mvpdemo2.ui.home.presenter;

import com.example.mvpdemo2.model.entity.InfoBean;
import com.example.mvpdemo2.model.network.RetrofitUtils;
import com.example.mvpdemo2.ui.home.contract.HomeContreact;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomePresenter implements HomeContreact.Presenter {
    private HomeContreact.View mView;

    @Override
    public void infoData(String type, String key) {
        RetrofitUtils.getInstance().getApi()
                .beans(type, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(InfoBean bean) {
                        mView.infoShow(bean);
                    }
                });
    }

    @Override
    public void attacth(HomeContreact.View view) {
        this.mView = view;
    }

    @Override
    public void death() {
        mView = null;
    }
}
