package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.model.GetTenantsList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Uv on 6/4/2018.
 */

public class SelectTenantAdapter extends RecyclerView.Adapter<SelectTenantAdapter.AddresssHolder>{

    private ArrayList<GetTenantsList> listData;
    private LayoutInflater inflater;
    private Context context;
    private RadioButton rbChecked = null;
    private int rbPosoition = 0;

    public SelectTenantAdapter(ArrayList<GetTenantsList> listData, Context context) {
        this.listData = listData;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public AddresssHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_select_tenant, parent,false);
        return new AddresssHolder(view,listData,context);    }

    @Override
    public void onBindViewHolder(final AddresssHolder holder, final int position) {
        /*GetTenantsList item = listData.get(position);
        holder.address.setText(item.getAddress());
        holder.name.setText(item.getName());*/
        holder.selected.setChecked(position == rbPosoition); // from this you only get one radio button selected in recycler view
        if (holder.selected.isChecked()){
            rbPosoition = holder.getAdapterPosition();
            Toast.makeText(context, "" + rbPosoition, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class AddresssHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView address, name;
        ImageView profile;
        LinearLayout linear_row;
        private RadioButton selected;
        private  View container;
        private  ArrayList<GetTenantsList> listData;
        Context context;

        public AddresssHolder(View itemView, final ArrayList<GetTenantsList> listdata, final Context context) {
            super(itemView);
            this.listData = listdata;
            this.context = context;
            itemView.setOnClickListener(this);
            linear_row = itemView.findViewById(R.id.linear_row);
            address = itemView.findViewById(R.id.text_address);
            name = itemView.findViewById(R.id.text_name);
            profile = itemView.findViewById(R.id.tenant_profile);
            selected = itemView.findViewById(R.id.select_radioButton);
            if (rbPosoition == 0 && selected.isChecked())
            {
                rbChecked = selected;
                rbPosoition = 0;
            }
           /* linear_row.setOnClickListener(this);
            View.OnClickListener l = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rbPosoition = getAdapterPosition();
                    notifyItemRangeChanged(0, listdata.size());
                    Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
                }
            };

            itemView.setOnClickListener(l);
            selected.setOnClickListener(l);*/
            selected.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RadioButton rb = (RadioButton) v;
                    int clickedPos = getAdapterPosition();
                    if (rb.isChecked()){
                        if(rbChecked != null)
                        {
                            rbChecked.setChecked(false);
                        }
                        rbChecked = rb;
                        rbPosoition = clickedPos;
                    }
                    else{
                        rbChecked = null;
                        rbPosoition = 0;
                    }

                }
            });

        }

        @Override
        public void onClick(View v) {

        }

       /* @Override
        public void onClick(View v) {
            int positenter code hereion = getAdapterPosition();
        }*/
    }
}