package com.example.myresume.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseOb<T> implements Observer<BaseResp<T>> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResp<T> tHttpResponse) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public abstract void onSucceed();

    public abstract void onFailure();
}