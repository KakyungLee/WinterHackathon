package com.example.user.library.activity.contest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.user.library.R;

/**
 * Created by user on 2017-12-19.
 */

public class ContestApplyActivity extends AppCompatActivity {

    private ImageButton aBook;
    private ImageButton bBook;
    private CheckBox agreeCheck;
    private Button submit;
    public  TextView selected ;
    public static String str = "";
    private String a = "수학하는 신체";
    private String b ="국가란 무엇인가";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contest_apply);
        // n 은 서버에서 몇회인지 받아오기
        int n = 4;
        setTitle("제 "+n+"회 독서 경시대회");

        selected = (TextView)findViewById(R.id.contest_apply_slected);

        aBook = (ImageButton)findViewById(R.id.contest_apply_abook);
        aBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText(a);
                str = a;
            }
        });


        bBook = (ImageButton)findViewById(R.id.contest_apply_bbook);
        bBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected.setText(b);
                str = b;
            }
        });


        agreeCheck = (CheckBox)findViewById(R.id.contest_apply_check);
        submit = (Button)findViewById(R.id.contest_apply_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!agreeCheck.isChecked())
                    return;
                else if( selected.getText().equals("")){
                    return;
                }
                else {
                    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    View mView = inflater.inflate(R.layout.contest_apply_dialog, null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(ContestApplyActivity.this);
                    builder.setView(mView);
                    final AlertDialog dialog = builder.create();
                    dialog.show();

                    Button ok = (Button) mView.findViewById(R.id.contest_apply_dialog_ok);
                    ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                            finish();
                        }
                    });
                }
            }
        });


    }
}