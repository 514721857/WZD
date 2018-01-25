package com.example.sgr.wzd.module.Tale;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseMvpLceFragment;
import com.example.sgr.wzd.module.common.CommonLcePresenter;
import com.example.sgr.wzd.module.common.CommonLceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaleFragment extends BaseMvpLceFragment<CommonLceView,CommonLcePresenter> implements CommonLceView {


    public TaleFragment() {
        // Required empty public constructor
    }


    @Override
    public int getContentView() {
        return R.layout.fragment_tale;
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
