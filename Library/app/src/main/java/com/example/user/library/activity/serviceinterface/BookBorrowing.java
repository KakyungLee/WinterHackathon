package com.example.user.library.activity.serviceinterface;

import com.example.user.library.activity.dto.Book_borrowing_join_list;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mooka on 2017-12-20.
 */

public interface BookBorrowing {
    @GET("/libserver/service/mypage/query/{student_num}")
    Call<Book_borrowing_join_list> borrowinglist (
        @Path("student_num") String student_num
    );
}
