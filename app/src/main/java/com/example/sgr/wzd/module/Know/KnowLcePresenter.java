package com.example.sgr.wzd.module.Know;

import android.content.Context;

import com.example.sgr.wzd.app.BasePresenter;
import com.example.sgr.wzd.model.DataServer;

/**
 * Data：2018/1/24/024-10:58
 * By  沈国荣
 * Description:
 */
public class KnowLcePresenter extends BasePresenter<KnowLceView> {
    public KnowLcePresenter(Context context) {
        super(context);
    }
    public void getNewsList(){
        getView().bindData( DataServer.getTestTdBeanData(2),"0");
    }

}
