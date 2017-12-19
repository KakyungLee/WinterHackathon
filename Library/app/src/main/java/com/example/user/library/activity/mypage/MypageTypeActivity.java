package com.example.user.library.activity.mypage;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.library.R;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;


/**
 * Created by user on 2017-12-19.
 */

public class MypageTypeActivity extends AppCompatActivity {

    private Integer[] mThumbIds = { R.drawable.image_contest,
            R.drawable.image_contest, R.drawable.image_contest,
            R.drawable.image_contest, R.drawable.image_contest,
            R.drawable.image_contest, R.drawable.image_contest,
            R.drawable.image_contest, R.drawable.image_contest
    };
    DisplayMetrics mMetrics;

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


        /////////////////////////////////////
        GridView gridview = (GridView) findViewById(R.id.mypage_type_gridview);
        gridview.setAdapter(new ImageAdapter( getApplicationContext()));
        gridview.setOnItemClickListener(gridviewOnItemClickListener);

        mMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
    }

    private GridView.OnItemClickListener gridviewOnItemClickListener
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {

            Toast.makeText(getApplicationContext(),
                    arg0.getAdapter().getItem(arg2).toString(),
                    Toast.LENGTH_LONG).show();
        }
    };

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return mThumbIds[position];
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {

            int rowWidth = (mMetrics.widthPixels) / 3;

            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(rowWidth,rowWidth));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(1, 1, 1, 1);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }
}