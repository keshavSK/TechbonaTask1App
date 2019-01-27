package com.example.dell_pc.techbonatask1app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubscriptionBodyPojo {

    @SerializedName("Username")
    @Expose
    private String username;

    public SubscriptionBodyPojo(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
