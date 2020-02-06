package com.example.myresume.network;

import com.example.myresume.base.BaseResp;
import com.example.myresume.bean.Menu;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface AllApi {

    /**
     * 获取banner
     */
    @GET("cook/queryid")
    Observable<BaseResp<Menu>> getCook(@QueryMap Map<String, String> map);


}
