package com.example.user.library.activity.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2017-12-20.
 */

public class CrollingRetrofit {
    private static CrollingRetrofit instance=new CrollingRetrofit();
    private Retrofit retrofit;
    Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    private CrollingRetrofit(){
        buildRetrofit();
    }

    private void buildRetrofit(){
        retrofit= new Retrofit.Builder()
                //서버의 base url 주소 등록
                .baseUrl("http://52.39.242.174:5000/favbooks")
                //json객체를 converting 해주는 라이브러리를 import 해야한다. build.gradle을 참고한다.
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static CrollingRetrofit getInstance(){
        return instance;
    }
    public Retrofit getRetrofit(){
        return retrofit;
    }
}
