package com.example.dell_pc.techbonatask1app;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;

public interface FeesReceiptInterface {

    @GET("FeeReceipt/GetFeeReceipt")
    Call<FeesReceiptResponsePojo> FEES_RECEIPT_RESPONSE_POJO_CALL(@HeaderMap HashMap<String, String> headerMap);
}
