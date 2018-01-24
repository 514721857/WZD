package com.example.sgr.wzd.http;



import com.example.sgr.wzd.model.dbBean.Test;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Data：2018/1/23/023-16:01
 * By  沈国荣
 * Description: 接口类
 */

public interface HttpService {



    /**
          测试示例
     * @param access_token
     * @param p
     * @param size
     * @param type_c
     * @return
             */
    @GET("app/app_mat/page")
    Observable<Test> getTest(@Query("access_token") String access_token, @Query("p") int p, @Query("size") int size, @Query("type_c") String type_c);

}
