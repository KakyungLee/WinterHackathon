package com.example.user.library.activity.serviceinterface;

import com.example.user.library.activity.dto.Book_search_list_dto;
import com.example.user.library.activity.dto.Student_info_dto;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by mooka on 2017-12-20.
 */

public interface BookSearch {
    @GET("/search/{str}/1")
    Call<Book_search_list_dto> bookSearch(
            @Path("str") String str
    );
}
