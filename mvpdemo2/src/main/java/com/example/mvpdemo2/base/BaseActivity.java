package com.example.mvpdemo2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvpdemo2.ui.home.presenter.HomePresenter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<T extends HomePresenter> extends AppCompatActivity {
   protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        parsePresenter();
//        presenter.attacth(this);
    }

    protected abstract int getLayoutID();

    private void parsePresenter(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        //获得第一个实现类中所有泛型参数的集合
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        //获得实现接口中第一个泛型的参数
        Class<T> tClass = (Class<T>) actualTypeArguments[0];
        try {
            //通过Java的动态代理来创建对象
            presenter = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
