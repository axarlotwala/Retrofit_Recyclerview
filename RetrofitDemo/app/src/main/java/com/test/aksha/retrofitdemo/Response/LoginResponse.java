package com.test.aksha.retrofitdemo.Response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @SerializedName("user_email")
    private String user_email;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("message")
    private String message;
    @SerializedName("response_code")
    private int response_code;
    @SerializedName("error")
    private boolean error;

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
