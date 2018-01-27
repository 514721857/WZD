package com.example.sgr.wzd.model;

import com.example.sgr.wzd.model.dbBean.NewsTitle;
import java.util.ArrayList;
import java.util.List;

/**测试数据
 * Created by Administrator on 2017/12/19/019.
 */

public class DataServer {

    public static List<NewsTitle> getTestTdBeanData(int lenth) {
        List<NewsTitle> list = new ArrayList<>();
        for (int i = 0; i < lenth; i++) {
            NewsTitle status = new NewsTitle();
            status.setTitle("标题"+i);
            status.setContent("内容"+i);
            list.add(status);
        }
        return list;
    }

}
