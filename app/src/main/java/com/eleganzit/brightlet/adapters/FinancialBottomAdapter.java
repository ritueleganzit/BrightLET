package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetFinancialBottom;

import java.util.ArrayList;

/**
 * Created by Uv on 6/11/2018.
 */

public class FinancialBottomAdapter extends RecyclerView.Adapter<FinancialBottomAdapter.MyViewHolder>
{
    ArrayList<GetFinancialBottom> arrayList;
    Context context;

    public FinancialBottomAdapter(ArrayList<GetFinancialBottom> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.outgoing_bottom_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title,cost;

        public MyViewHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            cost=itemView.findViewById(R.id.cost);

        }
    }
}
