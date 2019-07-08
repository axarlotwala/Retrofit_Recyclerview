package com.example.retrofitcrud.Activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.retrofitcrud.R;
import com.example.retrofitcrud.ResponseModel.UploadResponse;
import com.example.retrofitcrud.Retrofit.RetrofitClient;
import com.example.retrofitcrud.Retrofit.RetrofitInterface;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileUploadActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatImageView choose_image;
    ImageView imageview;
    TextInputEditText profile_name;
    Button btn_upload;
    Uri filepath;
    Bitmap bitmap;
    private static final int PICK_IMG_REQUEST = 1;
    String abs_path;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_upload);

        choose_image = findViewById(R.id.choose_image);
        imageview = findViewById(R.id.imageview);
        profile_name = findViewById(R.id.profile_name);
        btn_upload = findViewById(R.id.btn_upload);

        choose_image.setOnClickListener(this);
        btn_upload.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.choose_image :
                image_choice();
                break;

            case R.id.btn_upload :
                upload_image();
                break;
        }
    }

    private void image_choice(){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Please choose Image"),PICK_IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==PICK_IMG_REQUEST && resultCode==RESULT_OK && data != null && data.getData() != null){

            filepath = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);
                imageview.setImageBitmap(bitmap);

/*
                    String[] proj = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getContentResolver().query(filepath, proj, null, null, null);
                    int col_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//                    cursor.getString(col_index);

                    abs_path = cursor.getString(col_index);*/




            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(ProfileUploadActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    private String getPath(Uri uri){

        String result ;

        Cursor cursor = getContentResolver().query(uri,null,null,null,null);

        if (cursor == null){
            result = uri.getPath();
        }else {

            cursor.moveToFirst();
            int id = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
            result = cursor.getString(id);
            cursor.close();

        }
        return result;
    }



    private void upload_image(){

        String image_name = profile_name.getText().toString().trim();
        abs_path = getPath(filepath);

        if (image_name.isEmpty()){
            profile_name.setError("Name Require");
            profile_name.requestFocus();
            return;
        }


        File file = new File(abs_path);
        RequestBody  requestBody = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part partimage = MultipartBody.Part.createFormData("image",file.getName(),requestBody);
        RequestBody namebody  = RequestBody.create(MediaType.parse("text/plain"),image_name);


        RetrofitInterface retrofitInterface = RetrofitClient.retrofitClient().create(RetrofitInterface.class);
        Call<UploadResponse> uploadResponseCall = retrofitInterface.UPLOAD_RESPONSE_CALL(partimage,namebody);

        uploadResponseCall.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(Call<UploadResponse> call, Response<UploadResponse> response) {

                UploadResponse uploadResponse = response.body();
                Toast.makeText(ProfileUploadActivity.this,uploadResponse.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Success",""+uploadResponse.getMessage());
            }

            @Override
            public void onFailure(Call<UploadResponse> call, Throwable t) {
                Toast.makeText(ProfileUploadActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("ErrorBody",""+t.getMessage());
            }
        });

    }


}
