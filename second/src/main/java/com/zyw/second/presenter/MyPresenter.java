package com.zyw.second.presenter;

import com.zyw.second.bean.ListBean;
import com.zyw.second.bean.TitleBean;
import com.zyw.second.model.MyModel;
import com.zyw.second.view.MyView;
import com.zyw.second.view.ResultCallBack;

import java.util.List;
public class MyPresenter {
    private final MyView view;
    private final MyModel myModel;

    public MyPresenter(MyView view) {
        this.view=view;
        myModel = new MyModel();
    }

    public void toTitleModel(){
        myModel.getTitleResult(new ResultCallBack<List<TitleBean.DataBean>>() {

            @Override
            public void onSuccess(List<TitleBean.DataBean> dataBeans) {
                view.onTitleSuccess(dataBeans);
            }

            @Override
            public void onFail(String msg) {
                view.onFail(msg);
            }
        });
    }

    public void toListModel(int cid){
       myModel.getListResult(cid, new ResultCallBack<List<ListBean.DataBean.DatasBean>>() {

           @Override
           public void onSuccess(List<ListBean.DataBean.DatasBean> datasBeans) {
               view.onListSuccess(datasBeans);
           }

           @Override
           public void onFail(String msg) {
               view.onFail(msg);
           }
       });
    }
}
