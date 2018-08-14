package com.example.retrofitdemo.ui.model.home.presenter;

import com.example.retrofitdemo.model.entity.InfoBean;
import com.example.retrofitdemo.model.http.RetrofitUtils;
import com.example.retrofitdemo.ui.model.home.contract.HomeContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View mView;

    @Override
    public void infoData(String url) {
        RetrofitUtils.getInstance().getApi().beans(url)
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
    public void attach(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void death() {
        this.mView = null;
    }
}
