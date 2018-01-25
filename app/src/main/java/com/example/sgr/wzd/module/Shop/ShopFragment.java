package com.example.sgr.wzd.module.Shop;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseMvpLceFragment;
import com.example.sgr.wzd.module.common.CommonLcePresenter;
import com.example.sgr.wzd.module.common.CommonLceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopFragment extends BaseMvpLceFragment<CommonLceView,CommonLcePresenter> implements CommonLceView {


    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_shop;
    }

    @Override
    public void initContentView(View contentView) {

    }

    @Override
    public void initNavigation(View contentView) {

    }

    @Override
    public CommonLcePresenter createPresenter() {
        return new CommonLcePresenter(getActivity());
    }
}
