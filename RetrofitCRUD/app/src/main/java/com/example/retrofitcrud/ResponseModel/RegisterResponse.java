package com.example.retrofitcrud.ResponseModel;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {


    @SerializedName("message")
    private String message;
    @SerializedName("error")
    private boolean error;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
