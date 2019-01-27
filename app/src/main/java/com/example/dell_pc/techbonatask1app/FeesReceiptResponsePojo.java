package com.example.dell_pc.techbonatask1app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FeesReceiptResponsePojo {

    @SerializedName("StatusCode")
    @Expose
    private String statusCode;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("PaymentClear")
    @Expose
    private Boolean paymentClear;
    @SerializedName("TotalPaidAmt")
    @Expose
    private Integer totalPaidAmt;
    @SerializedName("TotalDueAmt")
    @Expose
    private Integer totalDueAmt;
    @SerializedName("NextDueDate")
    @Expose
    private Object nextDueDate;
    @SerializedName("TotalAmt")
    @Expose
    private Integer totalAmt;
    @SerializedName("FeeReceipts")
    @Expose
    private List<FeeReceipt> feeReceipts = null;

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

    public Boolean getPaymentClear() {
        return paymentClear;
    }

    public void setPaymentClear(Boolean paymentClear) {
        this.paymentClear = paymentClear;
    }

    public Integer getTotalPaidAmt() {
        return totalPaidAmt;
    }

    public void setTotalPaidAmt(Integer totalPaidAmt) {
        this.totalPaidAmt = totalPaidAmt;
    }

    public Integer getTotalDueAmt() {
        return totalDueAmt;
    }

    public void setTotalDueAmt(Integer totalDueAmt) {
        this.totalDueAmt = totalDueAmt;
    }

    public Object getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(Object nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    public Integer getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(Integer totalAmt) {
        this.totalAmt = totalAmt;
    }

    public List<FeeReceipt> getFeeReceipts() {
        return feeReceipts;
    }

    public void setFeeReceipts(List<FeeReceipt> feeReceipts) {
        this.feeReceipts = feeReceipts;
    }

}
