package com.example.sgr.wzd.module.Know;

import android.view.View;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseMvpLceFragment;
import com.example.sgr.wzd.module.common.CommonLcePresenter;
import com.example.sgr.wzd.module.common.CommonLceView;

public class KnowFragment extends BaseMvpLceFragment<CommonLceView,CommonLcePresenter> implements CommonLceView  {

    public KnowFragment() {
        // Required empty public constructor
    }

    @Override
    public CommonLcePresenter createPresenter() {
        return new CommonLcePresenter(getActivity());
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_know;
    }

    @Override
    public void initContentView(View contentView) {

    }

    @Override
    public void initNavigation(View contentView) {

    }
}
