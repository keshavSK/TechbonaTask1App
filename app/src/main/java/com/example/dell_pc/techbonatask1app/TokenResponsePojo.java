package com.example.dell_pc.techbonatask1app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenResponsePojo {

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("FeeReceiptCount")
    @Expose
    private Integer feeReceiptCount;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getFeeReceiptCount() {
        return feeReceiptCount;
    }

    public void setFeeReceiptCount(Integer feeReceiptCount) {
        this.feeReceiptCount = feeReceiptCount;
    }
}
