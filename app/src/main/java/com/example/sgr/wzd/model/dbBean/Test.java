package com.example.sgr.wzd.model.dbBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Data：2018/1/23/023-16:19
 * By  沈国荣
 * Description:这是一个测试类
 */
@Entity
public class Test {
    String test;

    public String getTest() {
        return this.test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Generated(hash = 642932876)
    public Test(String test) {
        this.test = test;
    }

    @Generated(hash = 372557997)
    public Test() {
    }
}
