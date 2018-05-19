package com.eleganzit.brightlet;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eleganzit.brightlet.utils.EqualSpacingItemDecoration;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CameraRollActivity extends AppCompatActivity {

    TextView done;
    RecyclerView grid;
    ArrayList<String> images=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_camera_roll);

        done=findViewById(R.id.done);
        grid=findViewById(R.id.grid);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(CameraRollActivity.this,3, LinearLayoutManager.VERTICAL,true);
        grid.addItemDecoration(new EqualSpacingItemDecoration(2, EqualSpacingItemDecoration.GRID)); // 16px. In practice, you'll want to use getDimensionPixelSize
        grid.setLayoutManager(layoutManager);
        grid.setAdapter(new GalleryAdapter(images,CameraRollActivity.this));

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CameraRollActivity.this,PreviewActivity.class));

            }
        });
    }
    public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder>
    {
        ArrayList<String> arrayList;
        Context context;

        public GalleryAdapter(ArrayList<String> arrayList, Context context) {
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


            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_layout,parent,false);

            MyViewHolder myViewHolder=new MyViewHolder(v);

            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


            Glide.with(context)
                    .load(images.get(position))
                    .into(holder.imageView);


        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public MyViewHolder(View itemView)
            {
                super(itemView);

                imageView=itemView.findViewById(R.id.img);
                //imageView=itemView.findViewById(R.id.img);
            }
        }
    }

}
