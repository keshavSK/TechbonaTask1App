package com.example.dell_pc.techbonatask1app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeeReceipt {

    @SerializedName("AmountPaid")
    @Expose
    private Integer amountPaid;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
    @SerializedName("RefundIssued")
    @Expose
    private Boolean refundIssued;
    @SerializedName("ReceiptNo")
    @Expose
    private Integer receiptNo;
    @SerializedName("ReceiptUrl")
    @Expose
    private String receiptUrl;

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getRefundIssued() {
        return refundIssued;
    }

    public void setRefundIssued(Boolean refundIssued) {
        this.refundIssued = refundIssued;
    }

    public Integer getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(Integer receiptNo) {
        this.receiptNo = receiptNo;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }
}
