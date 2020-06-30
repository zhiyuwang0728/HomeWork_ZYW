package com.zyw.second.view;

public interface ResultCallBack<T> {

    void onSuccess(T t);

    void onFail(String msg);
}
