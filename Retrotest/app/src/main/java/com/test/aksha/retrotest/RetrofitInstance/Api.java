package com.test.aksha.retrotest.RetrofitInstance;

import com.test.aksha.retrotest.POJO.Category_model;
import com.test.aksha.retrotest.POJO.Categorydetail_model;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @POST("fetchCategoryName")
    @FormUrlEncoded
    Call<Category_model> GetData(@Field("token") String AccessToken);

    @POST("fetchSingleCategoryName")
    @FormUrlEncoded
    Call<Categorydetail_model> GetSingleProductDetails (@Field("token") String AccessToken,@Field("category_id") String Category_Id);


}
