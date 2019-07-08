package com.test.aksha.retrofitdemo.Activity;

import android.content.Intent;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.test.aksha.retrofitdemo.R;
import com.test.aksha.retrofitdemo.Response.RegistrationResponse;
import com.test.aksha.retrofitdemo.Retrofit.RetrofitCalling;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText username,phone,user_email,user_password;
    RadioGroup radio_gender;
    MaterialButton register_button;
    AppCompatRadioButton radioButton;
    TextView login_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
        login_event = findViewById(R.id.login_event);

        radio_gender = findViewById(R.id.radio_gender);
        register_button = findViewById(R.id.register_button);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterData();
            }
        });

        login_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void RegisterData() {

        String name = username.getText().toString().trim();
        String phoneno = phone.getText().toString().trim();
        String email = user_email.getText().toString().trim();
        String password = user_password.getText().toString().trim();

        if (name.isEmpty()){
            username.setError("Name Require");
            username.requestFocus();
            return;
        }

        if (phoneno.isEmpty()){
            phone.setError("Phone No Require");
            phone.requestFocus();
            return;
        }

        if (email.isEmpty()){
            user_email.setError("Email Require");
            user_email.requestFocus();
            return;
        }

        if (password.isEmpty()){
            user_password.setError("Password Require");
            user_password.requestFocus();
            return;
        }

        int SELECTID = radio_gender.getCheckedRadioButtonId();
        radioButton = findViewById(SELECTID);

        String get_value = radioButton.getText().toString().trim();


        /*Call Retrofit Method*/

    }
}
