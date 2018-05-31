package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;

import java.util.ArrayList;

/**
 * Created by Uv on 5/19/2018.
 */

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.MyViewHolder>
{

    ArrayList<String> arrayList;
    Context context;

    public PropertyAdapter(ArrayList<String> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_property,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
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
        BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        LinearLayout manage_tenants=dialog.findViewById(R.id.manage_tenants_b);
        LinearLayout maintenance=dialog.findViewById(R.id.maintenance_b);
        LinearLayout image_file=dialog.findViewById(R.id.image_file_b);
        LinearLayout expenses=dialog.findViewById(R.id.expenses_b);
        LinearLayout documents_center=dialog.findViewById(R.id.documents_center_b);
        LinearLayout landlord_services=dialog.findViewById(R.id.landlord_services_b);
        dialog.show();
    }
}
