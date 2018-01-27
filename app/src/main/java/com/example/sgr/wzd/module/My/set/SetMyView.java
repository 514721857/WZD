package com.example.sgr.wzd.module.My.set;

import com.tz.mvp.framework.support.lce.MvpLceView;

/**
 * Data：2018/1/24/024-10:56
 * By  沈国荣
 * Description:V层接口
 */
public interface SetMyView extends MvpLceView {
    /**
     * 0表示女，1表示男
     * @param sex
     */
    void onSetSex(int  sex);
}
