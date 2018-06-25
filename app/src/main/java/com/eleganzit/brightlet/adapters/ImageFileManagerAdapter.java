package com.eleganzit.brightlet.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.eleganzit.brightlet.EditImageFileActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.model.GetImageFiles;
import com.github.gfranks.minimal.notification.GFMinimalNotification;

import java.util.ArrayList;

/**
 * Created by Uv on 6/1/2018.
 */

public class ImageFileManagerAdapter extends RecyclerView.Adapter<ImageFileManagerAdapter.MyViewHolder>
{
    ArrayList<GetImageFiles> arrayList;
    Context context;
    LinearLayout main;
    TableRow download,edit,delete;
    LinearLayout cancel,delete_b;

    public ImageFileManagerAdapter(ArrayList<GetImageFiles> arrayList, Context context, LinearLayout main) {
        this.arrayList = arrayList;
        this.context = context;
        this.main = main;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.file_manager_layout,parent,false);

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
        return 5;
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
        View sheet=inflater.inflate(R.layout.image_file_options,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        download=dialog.findViewById(R.id.manage_tenants_bt);
        edit=dialog.findViewById(R.id.maintenance_b);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,EditImageFileActivity.class));
            }
        });
        delete=dialog.findViewById(R.id.image_file_b);
        dialog.show();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                initbottomsheet1();
            }
        });
    }
    public void initbottomsheet1()
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sheet=inflater.inflate(R.layout.delete_property,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(context);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        cancel=dialog.findViewById(R.id.cancel);
        delete_b=dialog.findViewById(R.id.delete);
        dialog.show();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        delete_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(main, "SUCCESSFUL", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_DEFAULT);
                mCurrentNotification.setCustomBackgroundColor(Color.parseColor("#FF5EBC00"));
                mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
                mCurrentNotification.setHelperImage(R.drawable.group_45);
                mCurrentNotification.show();
                dialog.dismiss();

            }
        });

    }

}
