package com.example.user.library.activity.mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.user.library.R;
import com.example.user.library.activity.CustomListviewAdapter;

/**
 * Created by user on 2017-12-19.
 */

public class MypageBorrowingAcitvity extends AppCompatActivity {

    private ListView borrowingList = null;
    private CustomListviewAdapter borrowingListViewAdapter = null;

    private ListView reservationList = null;
    private CustomListviewAdapter reservationListViewAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_borrowing);
        setTitle("현황");

        borrowingList = (ListView)findViewById(R.id.mypage_borrowing_listview);
        borrowingListViewAdapter = new CustomListviewAdapter(getApplicationContext());
        borrowingList.setAdapter(borrowingListViewAdapter);

        ///// 테스트 데이터 입니다 서버에서 데이터를 넣어주시면 되요 <대겨 >
        String type ="borrowing";
        borrowingListViewAdapter.addItem(
                type,
                getResources().getDrawable(R.drawable.image_mypage, null),
                "해리포터_불사조기사단",
                "대출일:"+"2016_12_30",
                "반납 마감일:"+"2017_01_30",
                null);

        borrowingListViewAdapter.addItem(
                type,
                getResources().getDrawable(R.drawable.image_mypage, null),
                "해리포터_죽음의 성물",
                "대출일:"+"2016_11_30",
                "반납 마감일:"+"2017_01_30",
                "연장");
        /////////////////////////////////////////////////////////////////////

        reservationList = (ListView)findViewById(R.id.mypage_reservation_listview);
        reservationListViewAdapter = new CustomListviewAdapter(getApplicationContext());
        reservationList.setAdapter(reservationListViewAdapter);

        ///// 테스트 데이터 입니다 서버에서 데이터를 넣어주시면 되요  <예약>
        String type1 ="reservation";
        reservationListViewAdapter.addItem(
                type1,
                getResources().getDrawable(R.drawable.image_mypage, null),
                "반지의 제왕",
                "예약일:"+"2016_12_30",
                "예약순위:"+"1",
                "취소");

        /////////////////////////////////////////////////////////////////////
    }
}
