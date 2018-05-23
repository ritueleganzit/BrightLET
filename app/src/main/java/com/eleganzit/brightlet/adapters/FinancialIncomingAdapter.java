package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetFinancialIncoming;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Uv on 5/23/2018.
 */

public class FinancialIncomingAdapter extends RecyclerView.Adapter<FinancialIncomingAdapter.MyViewHolder>
{
    ArrayList<GetFinancialIncoming> arrayList;
    Context context;

    public FinancialIncomingAdapter(ArrayList<GetFinancialIncoming> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.incoming_statements_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextViewMuseo500 address,cost;

        public MyViewHolder(View itemView) {
            super(itemView);

            address=itemView.findViewById(R.id.address);
            cost=itemView.findViewById(R.id.cost);

        }
    }
}
