package com.eleganzit.brightlet;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.eleganzit.brightlet.adapters.LandlordServicesAdapter;
import com.eleganzit.brightlet.model.GetServices;

import java.util.ArrayList;

public class LandlordServicesActivity extends AppCompatActivity {

    RecyclerView ln_services;
    RelativeLayout main;
    ArrayList<GetServices> arrayList=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_landlord_services);

        ln_services=findViewById(R.id.ln_services);
        main=findViewById(R.id.r_main);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(LandlordServicesActivity.this,LinearLayoutManager.VERTICAL,false);
        ln_services.setLayoutManager(layoutManager);

        ln_services.setAdapter(new LandlordServicesAdapter(arrayList,LandlordServicesActivity.this,main));
    }
}
