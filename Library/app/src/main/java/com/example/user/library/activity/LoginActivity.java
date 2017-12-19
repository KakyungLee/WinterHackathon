package com.example.user.library.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.library.R;
import com.example.user.library.activity.dto.Student_info_dto;
import com.example.user.library.activity.main.MainActivity;
import com.example.user.library.activity.serviceinterface.LoginInfo;
import com.example.user.library.activity.util.ServiceRetrofit;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by user on 2017-12-19.
 */

public class LoginActivity extends Activity {

    private EditText id;
    private EditText password;
    private Button login;
    private Button moveLibrary;
    public static Student_info_dto studentinfo=null;
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
                LoginInfo login= ServiceRetrofit.getInstance().getRetrofit().create(LoginInfo.class);
                Call<Student_info_dto> call = login.loginInfo(strId,strPassword);
                new LoginProcess().execute(call);
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

    private class LoginProcess extends AsyncTask<Call, Void, Student_info_dto> {
        protected Student_info_dto doInBackground(Call... params){
            try{
                Call<Student_info_dto> call=params[0];
                Response<Student_info_dto> response = call.execute();
                return response.body();
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(Student_info_dto result) {
             studentinfo = result;
            System.out.println(studentinfo.getStudnet_num());
        }
    }


}
