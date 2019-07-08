package com.test.aksha.retrofitdemo.Response;

public class RegistrationResponse {

    private Boolean error;
    private int response_code;
    private String message;
    private String user_id;

    public RegistrationResponse() {
    }

    public RegistrationResponse(Boolean error, int response_code, String message, String user_id) {
        this.error = error;
        this.response_code = response_code;
        this.message = message;
        this.user_id = user_id;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
