package com.example.sgr.wzd.module.Know;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseMvpLceFragment;
import com.example.sgr.wzd.app.baseLce.BaseRefreshLceFragment;
import com.example.sgr.wzd.model.dbBean.NewsTitle;
import com.example.sgr.wzd.module.common.CommonLcePresenter;
import com.example.sgr.wzd.module.common.CommonLceView;
import com.example.sgr.wzd.module.common.adapter.KnowAdapter;

import java.util.List;

public class KnowFragment extends BaseRefreshLceFragment<KnowLceView,KnowLcePresenter> implements KnowLceView  {

    public KnowFragment() {
        // Required empty public constructor
    }

    @Override
    public KnowLcePresenter createPresenter() {
        return new KnowLcePresenter(getActivity());
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_know;
    }

    @Override
    public void initContentView(View contentView) {
        super.initContentView(contentView);
       setRefresh(false);//关闭上拉和下拉
    }

    @Override
    public void initNavigation(View contentView) {

    }

    @Override
    public BaseQuickAdapter bindAdapter() {
        return new KnowAdapter();
    }

    @Override
    public void loadData(boolean pullToRefresh, int page) {
        super.loadData(pullToRefresh, page);
        getPresenter().getNewsList();//测试数据
    }

    @Override
    public void initData() {
        super.initData();

        loadData(false,0);
    }

    @Override
    public void bindData(Object data, String type) {
        super.bindData(data, type);
        List<NewsTitle> tempBean=(List<NewsTitle>)data;
        refresh(false,tempBean);
    }

    @Override
    public void refreshData(boolean isDownRefresh, int page) {
        super.refreshData(isDownRefresh, page);
    }
}
