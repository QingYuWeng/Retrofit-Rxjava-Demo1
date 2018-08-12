package com.example.yuwenqing.okhttp.Models;

import com.example.yuwenqing.okhttp.Entities.Translation;

import io.reactivex.Observable;

public interface TranslationModel {
    public Observable<Translation> getResult(String content);
}
