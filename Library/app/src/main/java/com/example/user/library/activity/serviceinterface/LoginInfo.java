package com.example.user.library.activity.serviceinterface;

import com.example.user.library.activity.dto.Student_info_dto;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by mooka on 2017-12-20.
 */
public interface LoginInfo {
    @FormUrlEncoded

    @POST("/libserver/service/login")
    Call<Student_info_dto> loginInfo(
            @Field("student_num") String student_num,
            @Field("student_password") String student_password
    );
}
