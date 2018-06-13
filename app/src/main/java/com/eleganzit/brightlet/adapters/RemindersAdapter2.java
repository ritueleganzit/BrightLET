package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.fonts.TextViewMuseo500;
import com.eleganzit.brightlet.model.GetReminders;

import java.util.ArrayList;

/**
 * Created by Uv on 6/12/2018.
 */

public class RemindersAdapter2 extends RecyclerView.Adapter<RemindersAdapter2.MyViewHolder>
{

    ArrayList<GetReminders> arrayList;
    Context context;
    TableRow edit,delete;

    public RemindersAdapter2(ArrayList<GetReminders> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.reminders_layout2,parent,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initbottomsheet();

            }
        });

    }


    @Override
    public int getItemCount() {
        return 15;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView day,time,title,description;
        ImageView options;

        public MyViewHolder(View itemView) {
            super(itemView);
            day=itemView.findViewById(R.id.day);
            time=itemView.findViewById(R.id.time);
            options=itemView.findViewById(R.id.options);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);

        }
    }
    public void initbottomsheet()
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sheet=inflater.inflate(R.layout.reminders_options,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        edit=dialog.findViewById(R.id.edit_b);
        delete=dialog.findViewById(R.id.delete_b);
        dialog.show();
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "edit", Toast.LENGTH_SHORT).show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
