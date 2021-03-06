package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eleganzit.brightlet.TradesmenChatActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.TradesmenChatActivity;
import com.eleganzit.brightlet.model.GetTenantsMessages;
import com.eleganzit.brightlet.model.GetTradesmenMessages;

import java.util.ArrayList;

/**
 * Created by Uv on 5/22/2018.
 */

public class TradesmenMessagesAdapter extends RecyclerView.Adapter<TradesmenMessagesAdapter.MyViewHolder>
{
    ArrayList<GetTradesmenMessages> arrayList;
    Context context;

    public TradesmenMessagesAdapter(ArrayList<GetTradesmenMessages> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.tradesmen_message_list,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        GetTradesmenMessages getTenantsMessages=arrayList.get(position);
        holder.profile.setImageResource(getTenantsMessages.getProfile_pic());
        holder.name.setText(getTenantsMessages.getName());
        holder.address.setText(getTenantsMessages.getAddress());
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, TradesmenChatActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView profile;
        TextView profile_txt;
        TextView name,address;
        LinearLayout message;
        public MyViewHolder(View itemView) {
            super(itemView);

            profile=itemView.findViewById(R.id.profile_pic);
            profile_txt=itemView.findViewById(R.id.profile_text);
            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            message=itemView.findViewById(R.id.message);

        }
    }
}
