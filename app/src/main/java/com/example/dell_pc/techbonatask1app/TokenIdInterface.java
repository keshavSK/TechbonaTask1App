package com.example.dell_pc.techbonatask1app;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TokenIdInterface {

    @Headers("Content-type: application/json")
    @POST("Subscriptions/RequestToken")
    Call<TokenResponsePojo> TOKEN_RESPONSE_POJO_CALL(@HeaderMap HashMap<String,String> headerMap, @Body TokenBodyPojo tokenBodyPojo);

}
