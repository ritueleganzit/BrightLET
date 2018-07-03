package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.fragments.Fragment_image_file_manager;
import com.eleganzit.brightlet.fragments.Fragment_rent;
import com.eleganzit.brightlet.model.GetTenants;
import com.eleganzit.brightlet.utils.CircleTransform;

import java.util.ArrayList;

/**
 * Created by Uv on 5/23/2018.
 */

public class TenantsAdapter extends RecyclerView.Adapter<TenantsAdapter.MyViewHolder>
{
    ArrayList<GetTenants> arrayList;
    Context context;
    TableRow edit_tenant,tenancy_agreement,my_rent,message_center,appointments;

    public TenantsAdapter(ArrayList<GetTenants> arrayList, Context context)
    {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.tenants_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        GetTenants getTenants=arrayList.get(position);


        if(getTenants.getTenancy_finished().equalsIgnoreCase("Occupying"))
        {
            holder.status.setBackgroundColor(Color.parseColor("#5ebc00"));
        }
        else if(getTenants.getTenancy_finished().equalsIgnoreCase("Awaiting tenant"))
        {
            holder.status.setBackgroundColor(Color.parseColor("#f39200"));

        }
        else if(getTenants.getTenancy_finished().equalsIgnoreCase("Tenancy Ended"))
        {
            holder.status.setBackgroundColor(Color.parseColor("#FFD03131"));

        }
        if(getTenants.getTenant_profile_image().equalsIgnoreCase(""))
        {
            holder.profile_txt.setText(getTenants.getTenant_initials());
            holder.profile_txt.setVisibility(View.VISIBLE);
            holder.profile.setVisibility(View.GONE);
        }
        else
        {
            holder.profile_txt.setVisibility(View.GONE);
            holder.profile.setVisibility(View.VISIBLE);
            Glide
                    .with(context)
                    .load(getTenants.getTenant_profile_image()).transform(new CircleTransform(context)).skipMemoryCache(true)
                    .override(150,150)
                    .into(holder.profile);
        }

        holder.name.setText(getTenants.getTenant_name());
        holder.address.setText(getTenants.getProperty_details());
        holder.status.setText(getTenants.getTenancy_finished());
        holder.time.setText(getTenants.getRenewal_date());
        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initbottomsheet();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView profile,options;
        TextViewMuseo500 name,address;
        TextView profile_txt,status,time;

        public MyViewHolder(View itemView) {
            super(itemView);
            profile=itemView.findViewById(R.id.profile_pic);
            profile_txt=itemView.findViewById(R.id.profile_text);
            name=itemView.findViewById(R.id.name);
            options=itemView.findViewById(R.id.options);
            address=itemView.findViewById(R.id.address);
            status=itemView.findViewById(R.id.status);
            time=itemView.findViewById(R.id.time);
        }
    }
    public void initbottomsheet()
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sheet=inflater.inflate(R.layout.tenants_options,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        edit_tenant=dialog.findViewById(R.id.edit_tenant_b);
        tenancy_agreement=dialog.findViewById(R.id.tenancy_agreement_b);
        my_rent=dialog.findViewById(R.id.my_rent_b);
        message_center=dialog.findViewById(R.id.message_center_b);
        appointments=dialog.findViewById(R.id.appointments_b);
        dialog.show();
        edit_tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "edut_tenant", Toast.LENGTH_SHORT).show();
            }
        });
        tenancy_agreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "tenancy_agreement", Toast.LENGTH_SHORT).show();
            }
        });
        my_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "my_rent", Toast.LENGTH_SHORT).show();
                Fragment_rent fragment_rent=new Fragment_rent();
                FragmentTransaction fragmentTransaction=((LandlordHomeActivity)context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment_rent);
                fragmentTransaction.commit();
                dialog.dismiss();

            }
        });
        message_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "message_center", Toast.LENGTH_SHORT).show();
            }
        });
        appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "appointments", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
