package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.model.GetServices;
import com.github.gfranks.minimal.notification.GFMinimalNotification;

import java.util.ArrayList;

/**
 * Created by Uv on 6/26/2018.
 */

public class LandlordServicesAdapter extends RecyclerView.Adapter<LandlordServicesAdapter.MyViewHolder>
{
    ArrayList<GetServices> arrayList;
    Context context;
    RelativeLayout main;
    LinearLayout cancel,delete_b;

    private Boolean isOut = false;
    private Animation right_to_left,left_to_right;

    public LandlordServicesAdapter(ArrayList<GetServices> arrayList, Context context, RelativeLayout main) {
        this.arrayList = arrayList;
        this.context = context;
        this.main = main;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.ln_service_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initbottomsheet1();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
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
    public void initbottomsheet1()
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sheet=inflater.inflate(R.layout.delete_service,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        cancel=dialog.findViewById(R.id.cancel);
        delete_b=dialog.findViewById(R.id.delete);
        dialog.show();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        delete_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(main, "SUCCESSFUL", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_DEFAULT);
                mCurrentNotification.setCustomBackgroundColor(Color.parseColor("#FF5EBC00"));
                mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
                mCurrentNotification.setHelperImage(R.drawable.group_45);
                mCurrentNotification.show();
                dialog.dismiss();

            }
        });

    }

}