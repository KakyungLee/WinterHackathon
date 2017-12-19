package com.example.user.library.activity.contest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.library.R;

public class CardViewActivity extends Activity {

    TextView menutitle;
    ImageView backgroundImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cardview);
        menutitle = (TextView)findViewById(R.id.item_title);
        backgroundImage = (ImageView)findViewById(R.id.item_background);

        menutitle.setText("스터디룸");
        backgroundImage.setImageResource(R.drawable.image_studyroom);
    }
}
