package com.example.user.library.activity.mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.library.R;
import com.example.user.library.activity.main.RVAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-12-19.
 */

public class MypageActivity extends AppCompatActivity {

    private List<com.example.user.library.activity.main.Menu> menus;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        menus = new ArrayList<>();
        menus.add(new com.example.user.library.activity.main.Menu("대출 및 예약 현황", R.drawable.image_studyroom));
        menus.add(new com.example.user.library.activity.main.Menu("취향 분석", R.drawable.image_contest));
        menus.add(new com.example.user.library.activity.main.Menu("대출 기록", R.drawable.image_mypage));
    }

    private void initializeAdapter(){
        RVMypageAdapter adapter = new RVMypageAdapter(getApplicationContext(),menus);
        rv.setAdapter(adapter);
    }
}
