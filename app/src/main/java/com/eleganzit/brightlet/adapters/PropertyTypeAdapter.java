package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.eleganzit.brightlet.R;

import java.util.ArrayList;

/**
 * Created by Uv on 5/23/2018.
 */

public class PropertyTypeAdapter extends RecyclerView.Adapter<PropertyTypeAdapter.MyViewHolder>
{
    ArrayList<String> types;
    Context context;
    private int lastCheckedPosition = -1;

    public PropertyTypeAdapter(ArrayList<String> types, Context context) {
        this.types = types;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.property_type_layout,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.type.setText(types.get(position));
        holder.radioButton.setChecked(position == lastCheckedPosition);
        if(holder.radioButton.isChecked())
        {
            holder.background.setBackgroundResource(R.drawable.button_bg_purple);
            holder.type.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.background.setBackgroundResource(R.drawable.button_bg_grey);
            holder.type.setTextColor(Color.parseColor("#cbcbcb"));

        }

    }

    @Override
    public int getItemCount() {
        return types.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView type;
        RadioButton radioButton;
        LinearLayout background;
        public MyViewHolder(View itemView) {
            super(itemView);
            type=itemView.findViewById(R.id.type);
            background=itemView.findViewById(R.id.background);
            radioButton=itemView.findViewById(R.id.select_radioButton);

            background.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //overlay.setVisibility(View.VISIBLE);

                    lastCheckedPosition = getAdapterPosition();
                    //because of this blinking problem occurs so
                    //i have a suggestion to add notifyDataSetChanged();
                    //   notifyItemRangeChanged(0, list.length);//blink list problem
                    notifyDataSetChanged();

                }
            });
        }
    }
}
