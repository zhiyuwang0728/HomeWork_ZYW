package com.zyw.day03.presenter;

import com.zyw.day03.bean.Bean;
import com.zyw.day03.model.MyModel;
import com.zyw.day03.view.MyView;
import com.zyw.day03.view.ResultCallBack;

import java.util.List;

public class MyPresenter {

    private final MyModel myModel;
    private final MyView view;

    public MyPresenter(MyView view) {
        myModel = new MyModel();
        this.view = view;
    }

    public void toModel() {
        myModel.getResult(new ResultCallBack<List<Bean.DataBean.DatasBean>>() {

            @Override
            public void onSuccess(List<Bean.DataBean.DatasBean> datasBeans) {
                view.onSuccess(datasBeans);
            }

            @Override
            public void onFail(String msg) {
                view.onFail(msg);
            }
        });
    }
}
