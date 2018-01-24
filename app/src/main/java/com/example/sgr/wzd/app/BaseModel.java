package com.example.sgr.wzd.app;

import android.content.Context;

import com.example.sgr.wzd.http.HttpUtils;
import com.tz.mvp.framework.base.model.MvpModel;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Data：2018/1/23/023-16:01
 * By  沈国荣
 * Description: 访问网络的封装类，model的基类
 */

public class BaseModel implements MvpModel {

    private Context context;

    public BaseModel(Context context){
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

//    接口基本地址
    public String getServerUrl(){
        return "http://baidu.com";
    }
    //  封装创建retrofit
    public <T> T buildService(Class<T> service){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getServerUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }
//  封装创建Observe
    public void buildObserve( Observable<Object> Mobservable,final HttpUtils.OnHttpResultListener onLceHttpResultListener){
        Mobservable .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        onLceHttpResultListener.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        onLceHttpResultListener.onError(new Exception(e));
                    }

                    @Override
                    public void onNext(Object model) {
                        onLceHttpResultListener.onResult(model);
                    }});

    }

}
