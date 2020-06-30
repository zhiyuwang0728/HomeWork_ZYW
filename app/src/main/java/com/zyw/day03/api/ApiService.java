package com.zyw.day03.api;

import com.zyw.day03.bean.Bean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {

    String baseUrl="https://www.wanandroid.com/";

    @GET("project/list/1/json?cid=294")
    Flowable<Bean> getData();
}
