package com.example.user.library.activity.mypage;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.user.library.R;
import com.example.user.library.activity.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-12-19.
 */

public class MypageActivity extends Activity {

    private List<com.example.user.library.activity.main.Menu> menus;
    private RecyclerView rv;
    private TextView major;
    private TextView studentNumber;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_main);

        rv=(RecyclerView)findViewById(R.id.rv);
        major = (TextView)findViewById(R.id.mypage_major);
        studentNumber = (TextView)findViewById(R.id.mypage_student_number);
        name = (TextView)findViewById(R.id.mypage_name);

        /// 서버에서 데이터를 받아서 설정하는 곳
        major.setText(LoginActivity.studentinfo.getStudent_department());
        studentNumber.setText(LoginActivity.studentinfo.getStudnet_num());
        name.setText(LoginActivity.studentinfo.getStudnet_name());
        ////

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        menus = new ArrayList<>();
        menus.add(new com.example.user.library.activity.main.Menu("대출 및 예약 현황", R.drawable.image_mypage_borrowing));
        menus.add(new com.example.user.library.activity.main.Menu("취향 분석", R.drawable.image_mypage_type));
        menus.add(new com.example.user.library.activity.main.Menu("대출 기록", R.drawable.image_mypage_borrowed));
    }

    private void initializeAdapter(){
        RVMypageAdapter adapter = new RVMypageAdapter(getApplicationContext(),menus);
        rv.setAdapter(adapter);
    }
}
