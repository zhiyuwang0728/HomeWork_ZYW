package com.zyw.second.view;

import com.zyw.second.bean.AClass;

import java.util.List;

public interface IView {

    void onSuccess(List<AClass> data);

    void onFail(String msg);

}
