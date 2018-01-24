package com.example.sgr.wzd.app.baseLce;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.wzd.R;
import com.tz.mvp.framework.base.presenter.MvpPresenter;
import com.tz.mvp.framework.support.lce.MvpLceView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者: Dream on 16/9/21 13:20
 * QQ:510278658
 * E-mail:510278658@qq.com
 */
public abstract class BaseRefreshLceFragment< V extends MvpLceView, P extends MvpPresenter<V>> extends BaseMvpLceFragment< V, P> {

    //google下啦刷新组件也是可以的
    private Unbinder unbinder;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private int page=1,pagesize=10;

    @BindView(R.id.xrefreshview)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private BaseQuickAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    private boolean isDownRefresh = true;//表示的是下拉刷新界面

    public boolean isDownRefresh() {
        return isDownRefresh;
    }


    public BaseQuickAdapter getAdapter() {
        return recyclerAdapter;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return linearLayoutManager;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //获取数据
    }

    @Override
    public void initContentView(View contentView) {
        initNavigation(contentView);
        initRefreshView();
        unbinder = ButterKnife.bind(getActivity());
    }

    @Override
    public void initNavigation(View contentView) {

    }
    public void initRefreshView() {
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        //设置列表为垂直方向显示
        recyclerView.setLayoutManager(linearLayoutManager);
        //绑定Adapter
        recyclerAdapter = bindAdapter();
        recyclerView.setAdapter(recyclerAdapter);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {//下拉刷新
                refreshData(true,page);


            }
        });
        recyclerAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {//上拉加载更多
                refreshData(false,page);
            }
        });

    }
    public abstract BaseQuickAdapter bindAdapter();
    //提供给子类决定是否需要下拉刷新功能

    public void refreshData(boolean isDownRefresh,int page) {
        this.page=page;
        this.isDownRefresh = isDownRefresh;
    }


    public void refresh(boolean isRefresh, List data) {
        if(isRefresh){
            page = 1;
            recyclerAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
            setData(isRefresh, data);
            recyclerAdapter.setEnableLoadMore(true);
            mSwipeRefreshLayout.setRefreshing(false);
        }else{
            setData(isRefresh, data);
        }
    }

    //将数据与适配器绑定
    private void setData(boolean isRefresh, List data) {
        page++;
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {//下拉刷新
            recyclerAdapter.setNewData(data);
        } else {//上拉加载更多
            if (size > 0) {
                recyclerAdapter.addData(data);
            }
        }
        if (size < pagesize) {
            //第一页如果不够一页就不显示没有更多数据布局
            recyclerAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(getActivity(), "没有更多的数据", Toast.LENGTH_SHORT).show();
        } else {
            recyclerAdapter.loadMoreComplete();
        }
    }

    @Override
    public void bindData(Object data,String type) {
        super.bindData(data,type);
        //如果你是下拉刷新组件,那么我就处理
        //刷新UI界面
 /*       if (isDownRefresh()) {
            //网络请求完成,关闭下拉刷新组件加载视图
            getRefreshView().stopRefresh();
        } else {
            getRefreshView().stopLoadMore();
        }*/
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存数据
    }

    public void refreshData(boolean isDownRefresh) {
        Log.e("refreshData","base");
        this.isDownRefresh = isDownRefresh;
    }

}
