package com.zyw.second.presenter;

import com.zyw.second.bean.AClass;
import com.zyw.second.model.IModel;
import com.zyw.second.view.IView;
import com.zyw.second.view.ResultCallBack;

import java.util.List;

public class IPresenter {
    private final IView iView;
    private final IModel iModel;

    public IPresenter(IView iView) {

        this.iView=iView;
        iModel = new IModel();
    }

    public void toModel(){
        iModel.getResult(new ResultCallBack<List<AClass>>() {

            @Override
            public void onSuccess(List<AClass> aClasses) {
                iView.onSuccess(aClasses);
            }

            @Override
            public void onFail(String msg) {
                iView.onFail(msg);
            }
        });
    }
}
