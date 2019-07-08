package com.test.aksha.retrofittest.Retrofit;

import com.test.aksha.retrofittest.Model.Category_model;
import com.test.aksha.retrofittest.Model.Categorydetail_model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("fetchCategoryName")
    Call<Category_model> GetData(@Field("token") String AccessToken);

    @FormUrlEncoded
    @POST("fetchSingleCategoryName")
    Call<Categorydetail_model> GetSingleData(@Field("token") String AccessToken,@Field("category_id") String category_id);

}
