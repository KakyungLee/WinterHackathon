package com.example.user.library.activity.mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.library.R;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;


/**
 * Created by user on 2017-12-19.
 */

public class MypageTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage_type);

        ValueLineChart mCubicValueLineChart = (ValueLineChart) findViewById(R.id.cubiclinechart);

        ValueLineSeries series = new ValueLineSeries();
        series.setColor(0xFF56B7F1);
        series.addPoint(new ValueLinePoint("총류", 2.4f));
        series.addPoint(new ValueLinePoint("철학", 3.4f));
        series.addPoint(new ValueLinePoint("종교", .4f));
        series.addPoint(new ValueLinePoint("사회", 1.2f));
        series.addPoint(new ValueLinePoint("자연", 2.6f));
        series.addPoint(new ValueLinePoint("기술", 1.0f));
        series.addPoint(new ValueLinePoint("예술", 3.5f));
        series.addPoint(new ValueLinePoint("언어", 2.4f));
        series.addPoint(new ValueLinePoint("문학", 2.4f));
        series.addPoint(new ValueLinePoint("역사", 3.4f));

        mCubicValueLineChart.addSeries(series);
        mCubicValueLineChart.startAnimation();
    }
}