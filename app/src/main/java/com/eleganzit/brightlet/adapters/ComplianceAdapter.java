package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetCompliance;

import java.util.ArrayList;

/**
 * Created by Uv on 6/25/2018.
 */

public class ComplianceAdapter extends RecyclerView.Adapter<ComplianceAdapter.MyViewHolder>
{
    ArrayList<GetCompliance> arrayList;
    Context context;

    public ComplianceAdapter(ArrayList<GetCompliance> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.compliance_layout,parent,false);

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

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,price;
        ImageView status;
        public MyViewHolder(View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            status=itemView.findViewById(R.id.status);

        }
    }

}
