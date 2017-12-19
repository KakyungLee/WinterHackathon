package com.example.user.library.activity.mypage;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.user.library.R;
import com.example.user.library.activity.CustomListviewAdapter;
import com.example.user.library.activity.LoginActivity;
import com.example.user.library.activity.dto.Book_borrowing_join_dto;
import com.example.user.library.activity.dto.Book_borrowing_join_list;
import com.example.user.library.activity.dto.Book_dto;
import com.example.user.library.activity.dto.Book_search_list_dto;
import com.example.user.library.activity.serviceinterface.BookBorrowing;
import com.example.user.library.activity.util.ServiceRetrofit;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

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
        setTitle("대여 기록");

        MenuList = (ListView)findViewById(R.id.mypage_borrowed_listview);
        ListViewAdapter = new CustomListviewAdapter(getApplicationContext());
        MenuList.setAdapter(ListViewAdapter);
        ////////////////////////////////
        /*
                LoginInfo login= ServiceRetrofit.getInstance().getRetrofit().create(LoginInfo.class);
                Call<Student_info_dto> call = login.loginInfo(strId,strPassword);
                new LoginProcess().execute(call);
                startActivity(intent);

*/
        BookBorrowing borrowing= ServiceRetrofit.getInstance().getRetrofit().create(BookBorrowing.class);
        Call<Book_borrowing_join_list> call=borrowing.borrowinglist(LoginActivity.studentinfo.getStudnet_num());
        new BorrowedProcess().execute(call);
        /////////////////////////////////
        ///// 테스트 데이터 입니다 서버에서 데이터를 넣어주시면 되요
        String type ="borrowed";
        ListViewAdapter.addItem(
                type,
                getResources().getDrawable(R.drawable.image_mypage, null),
                "해리포터_불사조기사단",
                "대출일:"+"2016_12_30",
                "모래뿐일 것이다 이상의 꽃이 없으면 쓸쓸한 인간에 남는",
                null);

        ListViewAdapter.addItem(
                type,
                getResources().getDrawable(R.drawable.image_mypage, null),
                "해리포터_죽음의 성물",
                "대출일:"+"2016_11_30",
                null,
                null);
        /////////////////////////////////////////////////////////////////////
    }



    private class BorrowedProcess extends AsyncTask<Call, Void, Book_borrowing_join_list> {
        protected Book_borrowing_join_list doInBackground(Call... params){
            try{
                Call<Book_borrowing_join_list> call=params[0];
                Response<Book_borrowing_join_list> response = call.execute();
                return response.body();
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Book_borrowing_join_list result) {
          for(Book_borrowing_join_dto dto : result.list){
              System.out.println(dto.book_name);
          }
        }
    }
}