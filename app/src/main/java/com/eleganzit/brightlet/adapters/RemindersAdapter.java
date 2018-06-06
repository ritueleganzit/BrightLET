package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetReminders;

import java.util.ArrayList;

/**
 * Created by Uv on 5/19/2018.
 */

public class RemindersAdapter extends RecyclerView.Adapter<RemindersAdapter.MyViewHolder>
{

    ArrayList<GetReminders> arrayList;
    Context context;

    public RemindersAdapter(ArrayList<GetReminders> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.reminders_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextViewMuseo500 day,time,title,description;

        public MyViewHolder(View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.day);
            time=itemView.findViewById(R.id.time);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);

        }
    }
}
