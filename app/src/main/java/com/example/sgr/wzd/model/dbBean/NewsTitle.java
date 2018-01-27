package com.example.sgr.wzd.model.dbBean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Data：2018/1/27/027-11:56
 * By  沈国荣 消息列表bean
 * Description:
 */

@Entity
public class NewsTitle {
    String title;
    String time;
    String content;
    String imgurl;
    public String getImgurl() {
        return this.imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Generated(hash = 2137168699)
    public NewsTitle(String title, String time, String content, String imgurl) {
        this.title = title;
        this.time = time;
        this.content = content;
        this.imgurl = imgurl;
    }
    @Generated(hash = 29338071)
    public NewsTitle() {
    }

}
