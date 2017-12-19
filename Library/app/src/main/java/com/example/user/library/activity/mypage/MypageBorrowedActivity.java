package com.example.user.library.activity.mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.user.library.R;
import com.example.user.library.activity.CustomListviewAdapter;

/**
 * Created by user on 2017-12-19.
 */

public class MypageBorrowedActivity extends AppCompatActivity {

    private ListView MenuList = null;
    private CustomListviewAdapter ListViewAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_borrowed);
        setTitle("독서경시대회 역대기록");

        MenuList = (ListView)findViewById(R.id.contest_history_listview);
        ListViewAdapter = new CustomListviewAdapter(getApplicationContext());
        MenuList.setAdapter(ListViewAdapter);

        ///// 테스트 데이터 입니다 서버에서 데이터를 넣어주시면 되요
        ListViewAdapter.addItem(getResources().getDrawable(R.drawable.image_mypage, null),
                "해리포터_불사조기사단",
                "2016_12_30",
                null,
                null);

        ListViewAdapter.addItem(getResources().getDrawable(R.drawable.image_mypage, null),
                "해리포터_죽음의 성물",
                "2016_11_30",
                null,
                null);
        /////////////////////////////////////////////////////////////////////
    }
}