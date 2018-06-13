package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetFinancialOutgoing;

import java.util.ArrayList;

/**
 * Created by Uv on 6/11/2018.
 */

public class FinancialOutgoingAdapter extends RecyclerView.Adapter<FinancialOutgoingAdapter.MyViewHolder>
{
    ArrayList<GetFinancialOutgoing> arrayList;
    Context context;

    public FinancialOutgoingAdapter(ArrayList<GetFinancialOutgoing> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.outgoing_statement_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextViewMuseo500 address,fees,advertising;

        public MyViewHolder(View itemView) {
            super(itemView);

            address=itemView.findViewById(R.id.address);
            fees=itemView.findViewById(R.id.fees);
            advertising=itemView.findViewById(R.id.advertising);

        }
    }
}
