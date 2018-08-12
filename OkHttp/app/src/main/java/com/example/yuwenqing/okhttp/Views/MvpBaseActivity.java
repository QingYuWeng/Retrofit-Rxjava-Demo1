package com.example.yuwenqing.okhttp.Views;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.yuwenqing.okhttp.Presenters.BasePresenter;
import com.example.yuwenqing.okhttp.Presenters.TranslationPresenter;

public abstract class MvpBaseActivity<T extends BasePresenter> extends AppCompatActivity{


    protected T mPresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    public abstract String getSrc();
    public abstract void showTrg(String result);


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detacheView();
        Log.i("TAG","destroied");
    }

    protected abstract void createPresenter();
}
