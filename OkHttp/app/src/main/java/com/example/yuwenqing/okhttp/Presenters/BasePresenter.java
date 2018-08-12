package com.example.yuwenqing.okhttp.Presenters;

import android.util.Log;

import com.example.yuwenqing.okhttp.Views.MainActivity;
import com.example.yuwenqing.okhttp.Views.MvpBaseActivity;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<T> {

    protected Reference<T> mViewRef;

    public void attachView(T view)
    {
        mViewRef=new WeakReference<T>(view);
    }

    protected T getView()
    {
        return mViewRef.get();

    }

    public boolean isViewAttached()
    {
        return mViewRef!=null&&mViewRef.get()!=null;
    }

    public void detacheView()
    {
        if(mViewRef!=null)
        {
            mViewRef.clear();
            mViewRef=null;
            Log.i("TAG","destroied,too");
        }
    }


}
