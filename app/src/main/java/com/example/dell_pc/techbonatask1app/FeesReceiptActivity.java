package com.example.dell_pc.techbonatask1app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeesReceiptActivity extends AppCompatActivity {

    private String scriptionId, tokenId;
    private RecyclerView mRecyclerView;
    private TextView tvPaidAmount, tvTotalAmt, tvDueAMout, tvDueDate;
    private FeeReceiptAdapter adapter;
    private List<FeeReceipt> receiptList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_receipt);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerReceipt);
        //tvPaidAmount = (TextView) findViewById(R.id.tvFeesTotalPaidAmt);
        tvTotalAmt = (TextView) findViewById(R.id.tvFeesTotalAmt);
        //   tvDueAMout = (TextView) findViewById(R.id.tvFeesDueAmt);
        //  tvDueDate = (TextView) findViewById(R.id.tvFeesDueDate);

        Intent intent = getIntent();

        if (intent != null) {

            scriptionId = intent.getExtras().getString("subscriptionId");
            tokenId = intent.getExtras().getString("tokenId");
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        receiptList = new ArrayList<>();

        getReceiptDetails(scriptionId, tokenId);
    }

    private void getReceiptDetails(String sId, String tId) {

        HashMap<String, String> headerMap = new HashMap<>();

        headerMap.put("Authorization", "Bearer " + tId);
        headerMap.put("x-api-key", sId);

        FeesReceiptInterface feesReceiptInterface = ApiClient.getRetrofit().create(FeesReceiptInterface.class);
        Call<FeesReceiptResponsePojo> feesReceiptResponsePojoCall = feesReceiptInterface.FEES_RECEIPT_RESPONSE_POJO_CALL(headerMap);

        feesReceiptResponsePojoCall.enqueue(new Callback<FeesReceiptResponsePojo>() {
            @Override
            public void onResponse(Call<FeesReceiptResponsePojo> call, Response<FeesReceiptResponsePojo> response) {

                if (response.body().getStatusCode().equals("200")) {

                    receiptList = response.body().getFeeReceipts();

                    tvTotalAmt.setText("" + getResources().getString(R.string.Rs) + " " + response.body().getTotalAmt());
                    //  tvPaidAmount.setText("" + getResources().getString(R.string.Rs) + " " + response.body().getTotalPaidAmt());
                    //   tvDueAMout.setText(": " + getResources().getString(R.string.Rs) + " " + response.body().getTotalDueAmt());

                   /* if (response.body().getNextDueDate().equals("")) {

                        tvDueDate.setText(": ");
                    }*/


                    if (receiptList.size() > 0) {

                        adapter = new FeeReceiptAdapter(FeesReceiptActivity.this, receiptList);

                        mRecyclerView.setAdapter(adapter);

                        adapter.notifyDataSetChanged();
                    } else {

                        Toast.makeText(FeesReceiptActivity.this, "No fees receipt founds...", Toast.LENGTH_SHORT).show();

                    }
                } else {

                    Toast.makeText(FeesReceiptActivity.this, "No Data found...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FeesReceiptResponsePojo> call, Throwable t) {

                t.printStackTrace();
            }
        });

    }
}
