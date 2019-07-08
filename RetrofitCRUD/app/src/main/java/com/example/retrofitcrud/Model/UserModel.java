package com.example.retrofitcrud.Model;

import com.google.gson.annotations.SerializedName;

public  class UserModel {


    @SerializedName("gender")
    private String gender;
    @SerializedName("student_class")
    private String student_class;
    @SerializedName("student_phone")
    private String student_phone;
    @SerializedName("student_address")
    private String student_address;
    @SerializedName("student_email")
    private String student_email;
    @SerializedName("student_name")
    private String student_name;
    @SerializedName("student_id")
    private String student_id;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
}
