package com.example.sgr.wzd.module.model;

import android.content.Context;


import com.example.sgr.wzd.app.BaseModel;
import com.example.sgr.wzd.http.HttpService;
import com.example.sgr.wzd.http.HttpUtils;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
/**
 * /**
 * Data：2018/1/23/023-16:01
 * By  沈国荣
 * Description: model层，访问数据且返回  类
 */

public class TestModel extends BaseModel {

    public TestModel(Context context) {
        super(context);
    }

    /**
     * 获取聚宝盆里的下载列表
     * @param access_token
     * @param p
     * @param size
     * @param type_c
     * @param onLceHttpResultListener
     */
    public void getJbpList(String access_token,int p,int size,String type_c,final HttpUtils.OnHttpResultListener onLceHttpResultListener){
        HttpService essenceService= buildService(HttpService.class);
        buildObserve((Observable)essenceService.getTest(access_token, p, size, type_c),onLceHttpResultListener);
    }
}
