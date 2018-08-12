package com.example.yuwenqing.okhttp.Presenters;

import android.util.Log;
import android.view.View;

import com.example.yuwenqing.okhttp.Entities.Translation;
import com.example.yuwenqing.okhttp.Models.TranslationModel;
import com.example.yuwenqing.okhttp.Models.TranslationModelImpl;
import com.example.yuwenqing.okhttp.Views.MainActivity;
import com.example.yuwenqing.okhttp.Views.MvpBaseActivity;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TranslationPresenter extends BasePresenter<MainActivity> {
    //Model接口，依赖抽象
    TranslationModel translationModel=new TranslationModelImpl();

    //获取翻译结果
    public void getTranslationResultAndShow()
    {

        translationModel.getResult(getView().getSrc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        Translation translation=(Translation)o;
                        String result=translation.getTranslateResult().get(0).get(0).getTgt();
                        getView().showTrg(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","查询失败");
                    }

                    @Override
                    public void onComplete() {
                        Log.i("TAG","查询成功");
                    }
                });
    }
}
