package com.eleganzit.brightlet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class ProfileActivity extends AppCompatActivity {

    TextView save;
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
}
