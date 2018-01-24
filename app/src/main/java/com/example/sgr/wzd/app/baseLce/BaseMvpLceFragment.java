package com.example.sgr.wzd.app.baseLce;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.support.lce.MvpLceView;
import com.tz.mvp.framework.support.lce.impl.MvpLceFragment;

/**
 * Created by Dream on 16/5/26.        MvpLceFragment
 */
public abstract class BaseMvpLceFragment< V extends MvpLceView, P extends MvpPresenter<V>> extends MvpLceFragment<V,P> {
    //我们自己的Fragment需要缓存视图
    private View viewContent;//缓存视图
    private boolean isInit;
    private boolean isPullToRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (viewContent == null){
            viewContent = inflater.inflate(getContentView(),container,false);
            initContentView(viewContent);
        }
        //判断Fragment对应的Activity是否存在这个视图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if (parent != null){
            //如果存在,那么我就干掉,重写添加,这样的方式我们就可以缓存视图
            parent.removeView(viewContent);
        }
        return viewContent;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isInit){
            this.isInit = true;
            initData();
        }
    }

    public abstract int getContentView();

    public void initData(){

    }
    public boolean isPullToRefresh() {
        return isPullToRefresh;
    }

    public abstract void initContentView(View contentView);
    public abstract void initNavigation(View contentView);

}
