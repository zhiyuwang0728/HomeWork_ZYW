package com.zyw.second.api;

import com.zyw.second.bean.ListBean;
import com.zyw.second.bean.TitleBean;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    String titleUrl = "https://www.wanandroid.com/";

    @GET("project/tree/json")
    Call<TitleBean> getTitleData();

    String listUrl = "https://www.wanandroid.com/project/";

    @GET("list/1/json")
    Call<ListBean> getListData(@Query("cid") int cid);


}
