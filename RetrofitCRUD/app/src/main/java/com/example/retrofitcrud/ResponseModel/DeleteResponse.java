package com.example.retrofitcrud.ResponseModel;

import com.google.gson.annotations.SerializedName;

public class DeleteResponse {

    @SerializedName("error")
    private boolean error;
    @SerializedName("message")
    private String message;

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
