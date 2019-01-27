package com.example.dell_pc.techbonatask1app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenBodyPojo {

    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Password")
    @Expose
    private String password;

    public TokenBodyPojo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
