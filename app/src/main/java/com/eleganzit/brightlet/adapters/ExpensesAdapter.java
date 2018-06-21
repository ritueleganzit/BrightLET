package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetExpenses;

import java.util.ArrayList;

/**
 * Created by Uv on 6/20/2018.
 */

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.MyViewHolder>
{
    ArrayList<GetExpenses> arrayList;
    Context context;

    public ExpensesAdapter(ArrayList<GetExpenses> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.expenses_layout,parent,false);

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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView date,cost;

        public MyViewHolder(View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.date);
            cost=itemView.findViewById(R.id.cost);

        }
    }
}
