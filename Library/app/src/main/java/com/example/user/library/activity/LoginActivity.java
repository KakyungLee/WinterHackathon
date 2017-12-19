package com.example.user.library.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.library.R;

/**
 * Created by user on 2017-12-19.
 */

public class LoginActivity extends AppCompatActivity {

    private EditText id;
    private EditText password;
    private Button login;
    private Button moveLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        id = (EditText)findViewById(R.id.login_id);
        password = (EditText)findViewById(R.id.login_password);
        login = (Button)findViewById(R.id.login_login);
        moveLibrary = (Button)findViewById(R.id.login_move_library);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strId = id.getText().toString();
                String strPassword = password.getText().toString();
                Toast.makeText(getApplicationContext(), strId+ " "+ strPassword, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        moveLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://library.sejong.ac.kr/index.ax")));
            }
        });
    }




}
