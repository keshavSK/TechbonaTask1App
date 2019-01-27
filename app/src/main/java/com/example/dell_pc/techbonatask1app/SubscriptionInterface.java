package com.example.dell_pc.techbonatask1app;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface SubscriptionInterface {

    @Headers("Content-type: application/json")
    @POST("Subscriptions/GetAuthKey")
    Call<SubscriptionResponsePojo> SUBSCRIPTION_RESPONSE_POJO_CALL(@Body SubscriptionBodyPojo subscriptionBodyPojo);
}
