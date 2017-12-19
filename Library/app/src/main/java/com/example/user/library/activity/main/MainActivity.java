package com.example.user.library.activity.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.library.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-12-19.
 */

public class MainActivity extends Activity {

    private List<Menu> menus;
    private RecyclerView rv;
    private EditText searchText;
    private ImageButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        rv=(RecyclerView)findViewById(R.id.rv);
        searchText = (EditText)findViewById(R.id.main_search_text);
        search = (ImageButton)findViewById(R.id.main_search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = searchText.getText().toString();
                if(str == null)
                    return;
                else
                    Toast.makeText(getApplicationContext(), str+" 검색을 합니다.", Toast.LENGTH_LONG).show();
            }
        });

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
