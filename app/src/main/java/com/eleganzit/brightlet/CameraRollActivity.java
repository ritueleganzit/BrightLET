package com.eleganzit.brightlet;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eleganzit.brightlet.utils.EqualSpacingItemDecoration;

import java.util.ArrayList;
import java.util.Collections;

public class CameraRollActivity extends AppCompatActivity {

    private boolean ascending = true;
    RecyclerView grid;
    TextView done;
    ArrayList<String> images=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(CameraRollActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},1);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_camera_roll);
        done=findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CameraRollActivity.this,PreviewActivity.class));
            }
        });
        grid=findViewById(R.id.grid);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(CameraRollActivity.this,3,LinearLayoutManager.VERTICAL,false);
        grid.addItemDecoration(new EqualSpacingItemDecoration(3,EqualSpacingItemDecoration.GRID)); // 16px. In practice, you'll want to use getDimensionPixelSize
        grid.setLayoutManager(layoutManager);
        sortData(ascending);
        ascending = !ascending;

    }
    private void sortData(boolean asc)
    {
        //SORT ARRAY ASCENDING AND DESCENDING
        if (asc)
        {
            Collections.sort(images);
        }
        else
        {
            Collections.reverse(images);
        }

        //ADAPTER
        grid.setAdapter(new RecyclerAdapter(images,CameraRollActivity.this));

    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
    {
        private int lastCheckedPosition = -1;

        ArrayList<String> arrayList;
        Context context;

        public RecyclerAdapter(ArrayList<String> arrayList, Context context) {
            this.context = context;
            images = getAllShownImagesPath(context);
        }

        ArrayList<String> getAllShownImagesPath(Context activity) {
            Uri uri;
            Cursor cursor;
            int column_index_data, column_index_folder_name;
            ArrayList<String> listOfAllImages = new ArrayList<String>();
            String absolutePathOfImage = null;
            uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

            String[] projection = { MediaStore.MediaColumns.DATA,
                    MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

            cursor = activity.getContentResolver().query(uri, projection, null,
                    null, null);

            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            column_index_folder_name = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
            while (cursor.moveToNext()) {
                absolutePathOfImage = cursor.getString(column_index_data);

                listOfAllImages.add(absolutePathOfImage);
            }
            return listOfAllImages;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

            MyViewHolder myViewHolder=new MyViewHolder(v);

            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


            Glide.with(context)
                    .load(images.get(position))
                    .into(holder.imageView);
            holder.radioButton.setChecked(position == lastCheckedPosition);
            if(holder.radioButton.isChecked())
            {
                holder.overlay.setVisibility(View.VISIBLE);
            }
            else
            {
                holder.overlay.setVisibility(View.GONE);
            }

        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            RadioButton radioButton;
            LinearLayout overlay;

            public MyViewHolder(View itemView)
            {
                super(itemView);

                imageView=itemView.findViewById(R.id.img);
                //imageView=itemView.findViewById(R.id.img);
                radioButton=itemView.findViewById(R.id.select_radioButton);
                overlay=itemView.findViewById(R.id.overlay);
                overlay.setVisibility(View.GONE);

                imageView.setOnClickListener(new View.OnClickListener() {
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

}