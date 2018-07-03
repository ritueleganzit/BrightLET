package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo300;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetServices;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Uv on 6/14/2018.
 */

public class Service1Adapter extends RecyclerView.Adapter<Service1Adapter.MyViewHolder>
{
    ArrayList<GetServices> arrayList;
    Context context;
    private Boolean isOut = false;
    private Animation right_to_left,left_to_right;
    public Service1Adapter(ArrayList<GetServices> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.service_layout,parent,false);
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
        TextView service,cost,name;
        ImageView delete;
        public MyViewHolder(View itemView) {
            super(itemView);
            service=itemView.findViewById(R.id.service);
            cost=itemView.findViewById(R.id.cost);
            name=itemView.findViewById(R.id.name);
            delete=itemView.findViewById(R.id.delete_service);

        }
    }


}
