package com.zyw.day03.view;

public interface ResultCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);

}
