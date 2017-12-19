package com.example.user.library.activity.contest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.library.R;

/**
 * Created by user on 2017-12-19.
 */

public class ContestQueryActivity extends AppCompatActivity {

    private ImageView book;
    private TextView bookTitle;
    private TextView number;
    private TextView stuNumber;
    private TextView name;
    private TextView major;
    private Button cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contest_query);
        // n 은 서버에서 몇회인지 받아오기
        int n = 4;
        setTitle("제 "+n+"회 독서 경시대회");

        book = (ImageView)findViewById(R.id.contest_query_book);
        bookTitle = (TextView)findViewById(R.id.contest_query_booktitle);
        number = (TextView)findViewById(R.id.contest_query_number);
        stuNumber = (TextView)findViewById(R.id.contest_query_stunumber);
        name = (TextView)findViewById(R.id.contest_query_name);
        major = (TextView)findViewById(R.id.contest_query_major);

        //////////////////서버에서 온 데이터를 설정하세요
        //book.setImageResource();

        if(ContestApplyActivity.str.equals("수학하는 신체")) {
            book.setImageResource(R.drawable.abook);
            bookTitle.setText("수학하는 신체");
            number.setText("10034u53o35");
            stuNumber.setText("1010100034");
            name.setText("김옥분");
            major.setText("경영학과");
        }
        else if(ContestApplyActivity.str.equals("국가란 무엇인가")){
            book.setImageResource(R.drawable.bbook);
            bookTitle.setText("국가란 무엇인가");
            number.setText("10034u53o35");
            stuNumber.setText("1010100034");
            name.setText("김옥분");
            major.setText("경영학과");
        }
        else{
            book.setImageResource(R.mipmap.ic_launcher);
            bookTitle.setText("");
            number.setText("");
            stuNumber.setText("");
            name.setText("");
            major.setText("");
        }
        //////////////////////////////////////////////

        cancle = (Button)findViewById(R.id.contest_query_cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // if(selecte.selected.toString().equals(""))
                //    return;

                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                View mView = inflater.inflate(R.layout.contest_query_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(ContestQueryActivity.this);
                builder.setView(mView);
                final AlertDialog dialog = builder.create();
                dialog.show();

                Button no = (Button) mView.findViewById(R.id.contest_query_no);
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        finish();
                    }
                });
                Button yes = (Button) mView.findViewById(R.id.contest_query_yes);
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                        //////////서버에서 취소 쿼리를 날리면 되요
                        book.setImageResource(R.mipmap.ic_launcher);
                        bookTitle.setText("");
                        number.setText("");
                        stuNumber.setText("");
                        name.setText("");
                        major.setText("");
                        ContestApplyActivity.str = "";
                        //////////////////////
                        finish();
                    }
                });
            }
        });



    }

}