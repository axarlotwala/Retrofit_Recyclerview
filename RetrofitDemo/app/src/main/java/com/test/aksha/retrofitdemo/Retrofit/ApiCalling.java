package com.test.aksha.retrofitdemo.Retrofit;

import com.test.aksha.retrofitdemo.Response.LoginResponse;
import com.test.aksha.retrofitdemo.Response.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiCalling {

    @FormUrlEncoded
    @POST("Register_Customer.php")
    Call<RegistrationResponse> REGISTRATION_RESPONSE_CALL(

            @Field("name") String username,
            @Field("phoneno") String phone_no,
            @Field("user_email") String emailAddress,
            @Field("user_password") String password,
            @Field("gender") String gender);


    @FormUrlEncoded
    @POST("Login_Customer.php")
    Call<LoginResponse> LOGIN_RESPONSE_CALL(

            @Field("user_email") String email,
            @Field("user_password") String user_password);

}
