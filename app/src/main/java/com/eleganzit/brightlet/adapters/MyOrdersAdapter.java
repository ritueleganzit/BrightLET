package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.fragments.Fragment_image_file_manager;
import com.eleganzit.brightlet.fragments.Fragment_my_order_details;
import com.eleganzit.brightlet.model.GetMyOrders;

import java.util.ArrayList;

/**
 * Created by Uv on 5/28/2018.
 */

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyViewHolder>
{

    ArrayList<GetMyOrders> arrayList;
    Context context;

    public MyOrdersAdapter(ArrayList<GetMyOrders> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_orders_layout,parent,false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_my_order_details fragment_my_order_details=new Fragment_my_order_details();
                FragmentTransaction fragmentTransaction=((LandlordHomeActivity)context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment_my_order_details);
                fragmentTransaction.commit();
            }
        });

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
        TextView cost;

        public MyViewHolder(View itemView) {
            super(itemView);

            cost=itemView.findViewById(R.id.cost);
            cost.setPaintFlags(cost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        }
    }
}
