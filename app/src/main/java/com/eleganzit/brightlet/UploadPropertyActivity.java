package com.eleganzit.brightlet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class UploadPropertyActivity extends AppCompatActivity {

    TextView next;
    EditText house_number,street_name,town,country,postcode;
    RecyclerView property_type,house_type;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_upload_property);

        next=findViewById(R.id.next);
        house_number=findViewById(R.id.house_number);
        street_name=findViewById(R.id.street_name);
        town=findViewById(R.id.town);
        country=findViewById(R.id.country);
        postcode=findViewById(R.id.postcode);
        //property_type=findViewById(R.id.property_type);
        //house_type=findViewById(R.id.house_type);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UploadPropertyActivity.this,InformationActivity.class));
            }
        });

    }
}
