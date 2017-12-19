package com.example.user.library.activity.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.library.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-12-19.
 */

public class MainActivity extends Activity {

    private List<Menu> menus;
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
        menus.add(new Menu("스터디룸", R.drawable.image_studyroom));
        menus.add(new Menu("독서경시대회", R.drawable.image_contest));
        menus.add(new Menu("나의 발자취", R.drawable.image_mypage));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(getApplicationContext(),menus);
        rv.setAdapter(adapter);
    }
}
