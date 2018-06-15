package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetAppointments;

import java.util.ArrayList;

/**
 * Created by Uv on 5/19/2018.
 */

public class AppointmentsAdapter extends RecyclerView.Adapter<AppointmentsAdapter.MyViewHolder>
{

    ArrayList<GetAppointments> arrayList;
    Context context;

    public AppointmentsAdapter(ArrayList<GetAppointments> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.appointments_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        LinearLayout status_bg;
        TextViewMuseo500 day,time,title,description,status;

        public MyViewHolder(View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.day);
            time=itemView.findViewById(R.id.time);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
            status_bg=itemView.findViewById(R.id.status_bg);
            status=itemView.findViewById(R.id.status);

        }
    }
}
