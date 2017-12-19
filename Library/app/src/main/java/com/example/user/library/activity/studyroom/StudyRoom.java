package com.example.user.library.activity.studyroom;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.library.R;

import java.util.ArrayList;
import java.util.Calendar;

public class StudyRoom extends AppCompatActivity {

    Intent intent;
    TextView tv;
    int year;
    int month;
    int day;
    ArrayList<TextView> textViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studyroom);

        tv = (TextView) findViewById(R.id.date);

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);

        tv.setText(year + "-" + month + "-" + day);
        Button button = (Button) findViewById(R.id.reserve);
        ImageButton rbt = (ImageButton) findViewById(R.id.rbt);
        ImageButton lbt = (ImageButton) findViewById(R.id.lbt);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                intent = new Intent(StudyRoom.this, ReserveActivity.class);
                startActivity(intent);
            }

        });

        rbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(year + "-" + month + "-" + (++day));
            }
        });

        lbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(year + "-" + month + "-" + (--day));
            }
        });
        init();
    }

    private void init() {
        TextView tv1 = (TextView) findViewById(R.id.i109);
        TextView tv2 = (TextView) findViewById(R.id.i110);
        tv1.setBackgroundColor(0xFF3e3e3e);
        tv2.setBackgroundColor(0xFF3e3e3e);

        TextView tv3 = (TextView) findViewById(R.id.i215);
        tv3.setBackgroundColor(0xFF3e3e3e);

        TextView tv4 = (TextView) findViewById(R.id.i315);
        TextView tv5 = (TextView) findViewById(R.id.i316);
        tv4.setBackgroundColor(0xFF3e3e3e);
        tv5.setBackgroundColor(0xFF3e3e3e);

        TextView tv6 = (TextView) findViewById(R.id.i712);
        TextView tv7 = (TextView) findViewById(R.id.i713);

        tv6.setBackgroundColor(0xFF3e3e3e);
        tv7.setBackgroundColor(0xFF3e3e3e);


        TextView tv8 = (TextView) findViewById(R.id.i1519);
        tv8.setBackgroundColor(0xFF3e3e3e);

        TextView tv9 = (TextView) findViewById(R.id.i1810);
        TextView tv10 = (TextView) findViewById(R.id.i1811);

        tv9.setBackgroundColor(0xFF3e3e3e);
        tv10.setBackgroundColor(0xFF3e3e3e);

        TextView tv11 = (TextView) findViewById(R.id.i1813);
        TextView tv12 = (TextView) findViewById(R.id.i1814);

        tv11.setBackgroundColor(0xFF3e3e3e);
        tv12.setBackgroundColor(0xFF3e3e3e);

        TextView tv13 = (TextView) findViewById(R.id.i1216);
        TextView tv14 = (TextView) findViewById(R.id.i1218);

        tv13.setBackgroundColor(0xFF3e3e3e);
        tv14.setBackgroundColor(0xFF3e3e3e);

        TextView tv15 = (TextView) findViewById(R.id.i1311);
        TextView tv16 = (TextView) findViewById(R.id.i1314);
        tv15.setBackgroundColor(0xFF3e3e3e);
        tv16.setBackgroundColor(0xFF3e3e3e  );

    }
}
