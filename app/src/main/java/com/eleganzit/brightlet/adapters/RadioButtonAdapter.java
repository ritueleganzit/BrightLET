package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.model.GetTenantsList;

import java.util.ArrayList;

/**
 * Created by Uv on 6/4/2018.
 */

public class RadioButtonAdapter extends RecyclerView.Adapter<RadioButtonAdapter.RadioButtonHolder>
{

    private int lastCheckedPosition = -1;
    ArrayList<GetTenantsList> arrayList;
    Context context;

    public RadioButtonAdapter(ArrayList<GetTenantsList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public RadioButtonHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.layout_select_tenant,parent,false);
        RadioButtonHolder radioButtonHolder=new RadioButtonHolder(v);

        return radioButtonHolder;
    }

    @Override
    public void onBindViewHolder(RadioButtonHolder holder, int position) {

        holder.name.setText(arrayList.get(position).getName());
        holder.radioButton.setChecked(position == lastCheckedPosition);

    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RadioButtonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;

        RadioButton radioButton;

        public RadioButtonHolder(View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.text_name);
            radioButton=itemView.findViewById(R.id.select_radioButton);

            radioButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastCheckedPosition = getAdapterPosition();

                    Intent intent = new Intent("message");
                    //            intent.putExtra("quantity",Integer.parseInt(quantity.getText().toString()));
                    //intent.putExtra("quantity",qty);
                    intent.putExtra("radiodata","checked");
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                    //because of this blinking problem occurs so
                    //i have a suggestion to add notifyDataSetChanged();
                    //   notifyItemRangeChanged(0, list.length);//blink list problem
                    notifyDataSetChanged();

                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}
