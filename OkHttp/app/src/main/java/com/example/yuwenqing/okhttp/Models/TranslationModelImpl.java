package com.example.yuwenqing.okhttp.Models;


import com.example.yuwenqing.okhttp.Api.PostRequest_Interface;
import com.example.yuwenqing.okhttp.Entities.Translation;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TranslationModelImpl implements TranslationModel {
    @Override
    public Observable<Translation> getResult(String content) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);

        Observable<Translation> observable = request.getCall(content);

        return observable;
    }
}
