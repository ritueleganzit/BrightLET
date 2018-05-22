package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetTenantsMessages;

import java.util.ArrayList;

/**
 * Created by Uv on 5/22/2018.
 */

public class TenantsMessagesAdapter extends RecyclerView.Adapter<TenantsMessagesAdapter.MyViewHolder>
{
    ArrayList<GetTenantsMessages> arrayList;
    Context context;

    public TenantsMessagesAdapter(ArrayList<GetTenantsMessages> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.tenants_message_list,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        GetTenantsMessages getTenantsMessages=arrayList.get(position);
        holder.profile.setImageResource(getTenantsMessages.getProfile_pic());
        holder.name.setText(getTenantsMessages.getName());
        holder.subject.setText(getTenantsMessages.getSubject());
        holder.address.setText(getTenantsMessages.getAddress());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView profile;
        TextView name,subject,address;
        public MyViewHolder(View itemView) {
            super(itemView);

            profile=itemView.findViewById(R.id.profile_pic);
            name=itemView.findViewById(R.id.name);
            subject=itemView.findViewById(R.id.subject);
            address=itemView.findViewById(R.id.address);

        }
    }
}
