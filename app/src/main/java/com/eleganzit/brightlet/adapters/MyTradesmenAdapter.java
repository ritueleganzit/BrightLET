package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetMyOrders;
import com.eleganzit.brightlet.model.GetMyTradesmen;

import java.util.ArrayList;

/**
 * Created by Uv on 5/28/2018.
 */

public class MyTradesmenAdapter extends RecyclerView.Adapter<MyTradesmenAdapter.MyViewHolder>
{

    ArrayList<GetMyTradesmen> arrayList;
    Context context;

    public MyTradesmenAdapter(ArrayList<GetMyTradesmen> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_tradesmen_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        public MyViewHolder(View itemView) {
            super(itemView);



        }
    }
}
