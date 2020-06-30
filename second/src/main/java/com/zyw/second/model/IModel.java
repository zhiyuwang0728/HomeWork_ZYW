package com.zyw.second.model;

import com.example.greendaodemo.db.AClassDao;
import com.zyw.second.app.MyApp;
import com.zyw.second.bean.AClass;
import com.zyw.second.view.ResultCallBack;

import java.util.List;

public class IModel {

    public void getResult(ResultCallBack resultCallBack){

        AClassDao aClassDao = MyApp.getInstance().getDaoSession().getAClassDao();
        List<AClass> list = aClassDao.queryBuilder().list();

        resultCallBack.onSuccess(list);

        if(aClassDao==null){
            resultCallBack.onFail("错误");
        }
    }
}
