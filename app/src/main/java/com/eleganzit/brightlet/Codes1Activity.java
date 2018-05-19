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
import android.widget.TextView;



public class Codes1Activity extends AppCompatActivity {


    TextView phone;
    Button submit;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_codes1);

        phone=findViewById(R.id.phone);
        submit=findViewById(R.id.submit);
        phone.setText(getResources().getString(R.string.enterphone1)+"+447850013354"+getResources().getString(R.string.enterphone2));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Codes1Activity.this,ProfileActivity.class));
            }
        });
    }
}
