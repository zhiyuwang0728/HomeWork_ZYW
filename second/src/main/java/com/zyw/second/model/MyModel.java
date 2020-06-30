package com.zyw.second.model;

import com.zyw.second.api.ApiService;
import com.zyw.second.bean.ListBean;
import com.zyw.second.bean.TitleBean;
import com.zyw.second.view.ResultCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {

    public void getTitleResult(final ResultCallBack callBack){

        new Retrofit.Builder()
                .baseUrl(ApiService.titleUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getTitleData()
                .enqueue(new Callback<TitleBean>() {
                    @Override
                    public void onResponse(Call<TitleBean> call, Response<TitleBean> response) {
                        List<TitleBean.DataBean> data = response.body().getData();
                        callBack.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Call<TitleBean> call, Throwable t) {
                        callBack.onFail(t.getMessage());
                    }
                });
    }


    public void getListResult(int cid,final ResultCallBack callBack){
        new Retrofit.Builder()
                .baseUrl(ApiService.listUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getListData(cid)
                .enqueue(new Callback<ListBean>() {
                    @Override
                    public void onResponse(Call<ListBean> call, Response<ListBean> response) {
                        List<ListBean.DataBean.DatasBean> datas = response.body().getData().getDatas();
                        callBack.onSuccess(datas);
                    }

                    @Override
                    public void onFailure(Call<ListBean> call, Throwable t) {
                        callBack.onFail(t.getMessage());
                    }
                });
    }
}
