package com.example.aksha.recyclerview.pojo;

import com.google.gson.annotations.SerializedName;

public class Categorymodel {


    @SerializedName("category_name")
    private String Category_Name;

    @SerializedName("category_image")
    private String Category_Image;


    public String getCategory_Name() {
        return Category_Name;
    }

    public String getCategory_Image() {
        return Category_Image;
    }
}
