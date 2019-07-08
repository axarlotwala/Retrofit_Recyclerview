package com.test.aksha.retrofitdemo.Activity;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.test.aksha.retrofitdemo.R;
import com.test.aksha.retrofitdemo.Response.LoginResponse;
import com.test.aksha.retrofitdemo.Retrofit.ApiCalling;
import com.test.aksha.retrofitdemo.Retrofit.RetrofitCalling;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText login_email,login_password;
    private MaterialButton login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_user();
            }
        });
    }

    private void login_user() {

        String email = login_email.getText().toString().trim();
        String password = login_password.getText().toString().trim();


        if (email.isEmpty()) {
            login_email.setError("EmailAddress Require");
            login_email.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            login_password.setError("Password Is Empty");
            login_password.requestFocus();
            return;
        }

        /*login User*/

        ApiCalling apiCalling = RetrofitCalling.getRetrofit().create(ApiCalling.class);
        Call<LoginResponse> loginResponseCall = apiCalling.LOGIN_RESPONSE_CALL(email,password);


        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if (loginResponse.getError() == false){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(LoginActivity.this,loginResponse.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
                else {
                    onStop();
                    Toast.makeText(LoginActivity.this,loginResponse.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
