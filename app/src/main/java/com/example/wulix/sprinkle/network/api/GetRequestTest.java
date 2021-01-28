package com.example.wulix.sprinkle.network.api;


import com.example.wulix.sprinkle.module.Translation1;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface GetRequestTest {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Call<Translation1> getCall(@Field("i") String targetSentence);
    // @GET注解的作用:采用Get方法发送网络请求
    // getCall() = 接收网络请求数据的方法
    // 其中返回类型为Call<*>，*是接收数据的类（即上面定义的Translation类）

}
