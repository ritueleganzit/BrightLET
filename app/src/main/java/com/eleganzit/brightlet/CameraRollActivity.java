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
import android.util.Log;
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

        //GridView gallery = (GridView) findViewById(R.id.galleryGridView);
        ActivityCompat.requestPermissions(CameraRollActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},1);
        /*gallery.setAdapter(new ImageAdapter(this));

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                if (null != images && !images.isEmpty())
                    Toast.makeText(
                            getApplicationContext(),
                            "position " + position + " " + images.get(position),
                            Toast.LENGTH_LONG).show();
                ;

            }
        });*/
        grid=findViewById(R.id.grid);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(CameraRollActivity.this,3,LinearLayoutManager.VERTICAL,false);
        //grid.addItemDecoration(new EqualSpacingItemDecoration(2,EqualSpacingItemDecoration.GRID)); // 16px. In practice, you'll want to use getDimensionPixelSize
        grid.setLayoutManager(layoutManager);
        grid.setAdapter(new RecyclerAdapter(images,CameraRollActivity.this));

    }

    /**
     * The Class ImageAdapter.
     */
   /* private class ImageAdapter extends BaseAdapter {

        *//** The context. *//*
        private Activity context;

        *//**
     * Instantiates a new image adapter.
     *
     * @param localContext
     *            the local context
     *//*
        public ImageAdapter(Activity localContext) {
            context = localContext;
            images = getAllShownImagesPath(context);
        }

        public int getCount() {
            return images.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            ImageView picturesView;
            if (convertView == null) {
                picturesView = new ImageView(context);
                picturesView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                picturesView.setLayoutParams(new GridView.LayoutParams(240, 240));

            } else {
                picturesView = (ImageView) convertView;
            }

            Glide.with(context)
                    .load(images.get(position))
                    .into(picturesView);


            return picturesView;
        }

        *//**
     * Getting All Images Path.
     *
     * @param //activity
     *            the activity
     * @return ArrayList with images Path
     *//*
        ArrayList<String> getAllShownImagesPath(Activity activity) {
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
    }*/

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
    {
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


            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_layout,parent,false);

            MyViewHolder myViewHolder=new MyViewHolder(v);

            return myViewHolder;

        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


            Log.d("imagedata",""+images.get(position));
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
