package com.example.dell_pc.techbonatask1app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class FeeReceiptAdapter extends RecyclerView.Adapter<FeeReceiptAdapter.ViewHolder> {

    private Context mContext;
    private List<FeeReceipt> list;

    public FeeReceiptAdapter(Context mContext, List<FeeReceipt> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.row_fees_receipt_1, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final FeeReceipt feeReceipt = list.get(i);

        viewHolder.tvReceiptNo.setText("" + feeReceipt.getReceiptNo());

        String date = feeReceipt.getCreatedDate();

        String[] data = date.split("T");
        String receiptDate = data[0];


        viewHolder.tvDate.setText("" + receiptDate);

        /*if (feeReceipt.getReceiptUrl().length() > 6) {

            SpannableString spannableString = new SpannableString(feeReceipt.getReceiptUrl());
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            viewHolder.tvReceiptUrl.setText(": " + spannableString);

        }*/

        viewHolder.mViewReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = feeReceipt.getReceiptUrl();

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                mContext.startActivity(browserIntent);
            }
        });


        viewHolder.tvAmout.setText(mContext.getResources().getString(R.string.Rs) + " " + feeReceipt.getAmountPaid());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvReceiptNo, tvDate, tvReceiptUrl, tvAmout;
        RelativeLayout mViewReceipt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvReceiptNo = itemView.findViewById(R.id.rowReceiptNo);
            tvDate = itemView.findViewById(R.id.rowReceiptDate);
            // tvReceiptUrl = itemView.findViewById(R.id.rowReceiptUrl);
            tvAmout = itemView.findViewById(R.id.rowPaidAmount);
            mViewReceipt = itemView.findViewById(R.id.rowLayoutReceiptUrl);
        }
    }
}
