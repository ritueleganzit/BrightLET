package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.Toast;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.ViewPropertyActivity;
import com.eleganzit.brightlet.fragments.Fragment_book_tradesperson;
import com.eleganzit.brightlet.fragments.Fragment_expenses;
import com.eleganzit.brightlet.fragments.Fragment_image_file_manager;

import java.util.ArrayList;

/**
 * Created by Uv on 5/19/2018.
 */

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.MyViewHolder>
{

    ArrayList<String> arrayList;
    Context context;
    TableRow manage_tenants,maintenance,image_file,expenses,documents_center,landlord_services;

    public PropertyAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_property,parent,false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ViewPropertyActivity.class);
                context.startActivity(intent);
            }
        });

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initbottomsheet();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        ImageView option;

        public MyViewHolder(View itemView) {
            super(itemView);
            option=itemView.findViewById(R.id.option);

        }
    }
    public void initbottomsheet()
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sheet=inflater.inflate(R.layout.property_options,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        manage_tenants=dialog.findViewById(R.id.manage_tenants_bt);
        maintenance=dialog.findViewById(R.id.maintenance_b);
        image_file=dialog.findViewById(R.id.image_file_b);
        expenses=dialog.findViewById(R.id.expenses_b);
        documents_center=dialog.findViewById(R.id.documents_center_b);
        landlord_services=dialog.findViewById(R.id.landlord_services_b);
        dialog.show();
        manage_tenants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "manage_tenants", Toast.LENGTH_SHORT).show();
            }
        });
        maintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "maintenance", Toast.LENGTH_SHORT).show();
            }
        });
        image_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "image_file", Toast.LENGTH_SHORT).show();
                Fragment_image_file_manager fragment_image_file_manager=new Fragment_image_file_manager();
                FragmentTransaction fragmentTransaction=((LandlordHomeActivity)context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment_image_file_manager);
                fragmentTransaction.commit();
                dialog.dismiss();
                /*welcome.setVisibility(View.GONE);
                title.setText("Properties");*/
            }
        });
        expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "expenses", Toast.LENGTH_SHORT).show();
                Fragment_expenses fragment_expenses=new Fragment_expenses();
                FragmentTransaction fragmentTransaction=((LandlordHomeActivity)context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_container,fragment_expenses);
                fragmentTransaction.commit();
                dialog.dismiss();
            }
        });
        documents_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "documents_center", Toast.LENGTH_SHORT).show();
            }
        });
        landlord_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "landlord_services", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
