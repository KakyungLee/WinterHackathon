package com.example.user.library.activity.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mooka on 2017-12-20.
 */

public class ServiceRetrofit {
    private static ServiceRetrofit instance=new ServiceRetrofit();
    private Retrofit retrofit;
    Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    private ServiceRetrofit(){
        buildRetrofit();
    }

    private void buildRetrofit(){
        retrofit= new Retrofit.Builder()
                //서버의 base url 주소 등록
                .baseUrl("http://13.125.9.186:8080/")
                //json객체를 converting 해주는 라이브러리를 import 해야한다. build.gradle을 참고한다.
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static ServiceRetrofit getInstance(){
        return instance;
    }
    public Retrofit getRetrofit(){
        return retrofit;
    }
}
