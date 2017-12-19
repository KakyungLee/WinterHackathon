package com.example.user.library.activity.contest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.library.R;
import com.example.user.library.activity.main.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-12-19.
 */

public class ContestActivity extends Activity {

    private List<Menu> menus;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contest_main);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        menus = new ArrayList<>();
        menus.add(new com.example.user.library.activity.main.Menu("신청", R.drawable.image_contest_apply));
        menus.add(new com.example.user.library.activity.main.Menu("조회", R.drawable.image_contest_query));
        menus.add(new com.example.user.library.activity.main.Menu("역대 기록", R.drawable.image_contest_history));
    }

    private void initializeAdapter(){
        RVContestAdapter adapter = new RVContestAdapter(getApplicationContext(),menus);
        rv.setAdapter(adapter);
    }
}