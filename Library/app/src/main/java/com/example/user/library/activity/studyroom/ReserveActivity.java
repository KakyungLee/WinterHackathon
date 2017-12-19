package com.example.user.library.activity.studyroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.example.user.library.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ReserveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        Spinner sp = (Spinner) findViewById(R.id.sp);
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


    }
}
