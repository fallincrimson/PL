package com.example.slide.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class DataAdmin {
    @SerializedName("user_id")
    String userId;
    @SerializedName("password")
    String password;

    public DataAdmin() {

    }

    public DataAdmin(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
