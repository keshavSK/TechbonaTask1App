package com.example.dell_pc.techbonatask1app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tvSubscription, tvTokenId;
    private ProgressBar mProgressBar;
    private String subscription, tokenId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSubscription = (TextView) findViewById(R.id.tv_mainSubscriptionId);
        tvTokenId = (TextView) findViewById(R.id.tv_mainTokenId);
        mProgressBar = (ProgressBar) findViewById(R.id.main_progressBar);

        findViewById(R.id.btn_mainSubscriptionId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subscription = "";
                tokenId = "";
                tvSubscription.setText("");
                tvTokenId.setText("");
                getSubscriptionId();
            }
        });

        findViewById(R.id.btn_tokenId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tokenId = "";
                tvTokenId.setText("");
                getTokenId(subscription);
            }
        });

        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FeesReceiptActivity.class);

                intent.putExtra("subscriptionId", subscription);
                intent.putExtra("tokenId", tokenId);

                startActivity(intent);
            }
        });
    }

    private void getTokenId(String subScriptionId) {

        mProgressBar.setVisibility(View.VISIBLE);

        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("x-api-key", subScriptionId);

        TokenIdInterface idInterface = ApiClient.getRetrofit().create(TokenIdInterface.class);

        Call<TokenResponsePojo> tokenResponsePojoCall = idInterface.TOKEN_RESPONSE_POJO_CALL(headerMap, new TokenBodyPojo("8390502610", "8390502610"));

        tokenResponsePojoCall.enqueue(new Callback<TokenResponsePojo>() {
            @Override
            public void onResponse(Call<TokenResponsePojo> call, Response<TokenResponsePojo> response) {

                mProgressBar.setVisibility(View.GONE);

                if (response.body().getStatusCode().equals("404")) {

                    tokenId = response.body().getToken();
                    tvTokenId.setText("" + tokenId);
                }
            }

            @Override
            public void onFailure(Call<TokenResponsePojo> call, Throwable t) {

                mProgressBar.setVisibility(View.GONE);
                t.printStackTrace();
            }
        });
    }

    private void getSubscriptionId() {

        mProgressBar.setVisibility(View.VISIBLE);

        SubscriptionInterface subscriptionInterface = ApiClient.getRetrofit().create(SubscriptionInterface.class);
        Call<SubscriptionResponsePojo> subscriptionResponsePojoCall = subscriptionInterface.SUBSCRIPTION_RESPONSE_POJO_CALL(new SubscriptionBodyPojo("8390502610"));

        subscriptionResponsePojoCall.enqueue(new Callback<SubscriptionResponsePojo>() {
            @Override
            public void onResponse(@NonNull Call<SubscriptionResponsePojo> call, @NonNull Response<SubscriptionResponsePojo> response) {

                mProgressBar.setVisibility(View.GONE);
                assert response.body() != null;

                if (response.body().getStatusCode().equals("200")) {

                    subscription = response.body().getSubcriptionId();
                    tvSubscription.setText("" + response.body().getSubcriptionId());
                }
            }

            @Override
            public void onFailure(Call<SubscriptionResponsePojo> call, Throwable t) {

                mProgressBar.setVisibility(View.GONE);
                t.printStackTrace();
            }
        });
    }
}
