package com.example.user.library.activity.studyroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.library.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ReserveActivity extends AppCompatActivity {
    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        sp = (Spinner) findViewById(R.id.sp);
        ArrayList<String> time = new ArrayList<String>();
        time.add("\t1 시간");
        time.add("\t2 시간");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, time);
        sp.setAdapter(adapter);


        Calendar c = Calendar.getInstance();
        int year = c.get(c.YEAR);
        int month = c.get(c.MONTH);
        int dayOfMonth = c.get(c.DAY_OF_WEEK);

        DatePicker dp = (DatePicker) findViewById(R.id.dp);
        TextView tv1 = (TextView) findViewById(R.id.n9);
        TextView tv2 = (TextView) findViewById(R.id.n10);
        TextView tv3 = (TextView) findViewById(R.id.n11);
        TextView tv4 = (TextView) findViewById(R.id.n12);
        TextView tv5 = (TextView) findViewById(R.id.n13);
        TextView tv6 = (TextView) findViewById(R.id.n14);
        TextView tv7 = (TextView) findViewById(R.id.n15);
        TextView tv8 = (TextView) findViewById(R.id.n16);
        TextView tv9 = (TextView) findViewById(R.id.n17);
        TextView tv10 = (TextView) findViewById(R.id.n18);
        TextView tv11 = (TextView) findViewById(R.id.n19);
        TextView tv12 = (TextView) findViewById(R.id.n20);

        ArrayList<TextView> tvlist = new ArrayList<>();
        tvlist.add(tv1);
        tvlist.add(tv2);
        tvlist.add(tv3);
        tvlist.add(tv4);
        tvlist.add(tv5);
        tvlist.add(tv6);
        tvlist.add(tv7);
        tvlist.add(tv8);
        tvlist.add(tv9);
        tvlist.add(tv10);
        tvlist.add(tv11);
        tvlist.add(tv12);

        for (int i = 0; i < tvlist.size(); i++) {
            tvlist.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setBackgroundColor(0xffffffff);
                }   
            });
        }
    }


}
