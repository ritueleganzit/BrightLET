package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.Toast;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.model.GetMyTradesmen;

import java.util.ArrayList;

/**
 * Created by Uv on 5/28/2018.
 */

public class MyTradesmenAdapter extends RecyclerView.Adapter<MyTradesmenAdapter.MyViewHolder>
{

    ArrayList<GetMyTradesmen> arrayList;
    Context context;
    TableRow edit_tradesmen,message;

    public MyTradesmenAdapter(ArrayList<GetMyTradesmen> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_tradesmen_layout,parent,false);

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
        return 2;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView options;
        public MyViewHolder(View itemView) {
            super(itemView);
                options=itemView.findViewById(R.id.options);


        }
    }
    public void initbottomsheet()
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sheet=inflater.inflate(R.layout.tradesmen_options,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        edit_tradesmen=dialog.findViewById(R.id.edit_tradesmen_b);
        message=dialog.findViewById(R.id.message_b);
        dialog.show();
        edit_tradesmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "edit_tradesmen", Toast.LENGTH_SHORT).show();
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "message", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
