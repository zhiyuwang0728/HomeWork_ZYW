package com.zyw.day03.view;

import com.zyw.day03.bean.Bean;

import java.util.List;

public interface MyView {


    void onSuccess(List<Bean.DataBean.DatasBean> data);

    void onFail(String msg);

}
