package com.eleganzit.brightlet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.io.File;
import java.io.IOException;

import static android.R.attr.bitmap;


public class ProfileActivity extends AppCompatActivity {

    private static final int SELECT_PICTURE = 100;
    TextView save;
    Bitmap bitmap;
    ImageView profile;
    EditText house_number,street_name,town,country,postcode,scheme;
    Button yes,no;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_profile);

        save=findViewById(R.id.save);
        profile=findViewById(R.id.profile_pic);
        house_number=findViewById(R.id.house_number);
        street_name=findViewById(R.id.street_name);
        town=findViewById(R.id.town);
        country=findViewById(R.id.country);
        postcode=findViewById(R.id.postcode);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        scheme=findViewById(R.id.scheme);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this,UploadPropertyActivity.class));
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                yes.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));
                yes.setTextColor(Color.parseColor("#ffffff"));
                /*if(v instanceof Button){
                    ((Button)v).setTextColor(Color.parseColor("#ffffff"));
                }*/
                no.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                no.setTextColor(Color.parseColor("#cbcbcb"));
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                no.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));
                no.setTextColor(Color.parseColor("#ffffff"));
                yes.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                yes.setTextColor(Color.parseColor("#cbcbcb"));

            }
        });
    }
    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK) {

            if (requestCode == SELECT_PICTURE) {
                File file = new File(String.valueOf(data));
                int file_size = Integer.parseInt(String.valueOf(file.length()/1024));
                Log.d("file_size1",""+file_size);
                onSelectFromGalleryResult(data);

            }
        }
        if (resultCode==RESULT_CANCELED)
        {

        }

    }
    private void onSelectFromGalleryResult(Intent data) {
        if (data != null) {
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (bitmap!=null)
        {

            Glide
                    .with(ProfileActivity.this)
                    .load(data.getData()).transform(new CircleTransform(ProfileActivity.this)).skipMemoryCache(true)
                    .into(profile);

        }
        else
        {
            Toast.makeText(this, "Image format not proper", Toast.LENGTH_SHORT).show();
        }

    }
    public static class CircleTransform extends BitmapTransformation {
        public CircleTransform(Context context) {
            super(context);
        }

        @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private static Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override public String getId() {
            return getClass().getName();
        }

    }
}
