package com.example.retrofitcrud.Retrofit;

import com.example.retrofitcrud.Model.UserModel;
import com.example.retrofitcrud.ResponseModel.DeleteResponse;
import com.example.retrofitcrud.ResponseModel.LoginResponse;
import com.example.retrofitcrud.ResponseModel.RegisterResponse;
import com.example.retrofitcrud.ResponseModel.UpdateResponse;
import com.example.retrofitcrud.ResponseModel.UploadResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface RetrofitInterface {

    @FormUrlEncoded
    @POST("register_student.php")
    Call<RegisterResponse> REGISTER_RESPONSE_CALL(

            @Field("student_name") String name,
            @Field("student_email") String email,
            @Field("student_address") String address,
            @Field("student_phone") String phone,
            @Field("student_class") String div,
            @Field("gender") String gender);



    @GET("all_student.php")
    Call<List<UserModel>> LIST_CALL();

    @FormUrlEncoded
    @POST("update_user.php")
    Call<UpdateResponse> UPDATE_RESPONSE_CALL(
            @Field("student_id") String student_id,
            @Field("student_name") String update_name,
            @Field("student_email") String update_email,
            @Field("student_address") String address,
            @Field("student_phone") String phone);

    @FormUrlEncoded
    @POST("delete_user.php")
    Call<DeleteResponse> DELETE_RESPONSE_CALL(
            @Field("student_id") String student_id);

    @FormUrlEncoded
    @POST("user_login.php")
    Call<LoginResponse> LOGIN_RESPONSE_CALL(@Field("student_email") String login_email,
                                            @Field("student_phone") String login_password);


    @Multipart
    @POST("upload_image.php")
    //Call<UploadResponse> UPLOAD_RESPONSE_CALL(@Part MultipartBody.Part files, @Part("name")RequestBody profile_name);
    Call<UploadResponse> UPLOAD_RESPONSE_CALL(@Part MultipartBody.Part image,
                                            @Part("name") RequestBody name);
}


