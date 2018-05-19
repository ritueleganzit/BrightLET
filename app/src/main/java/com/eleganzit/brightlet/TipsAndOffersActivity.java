package com.eleganzit.brightlet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


public class TipsAndOffersActivity extends AppCompatActivity {

    Button accept,yes,no;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_tips_and_offers);

        accept=findViewById(R.id.accept);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);

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
        /*yes.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    yes.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));


                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    yes.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));

                }

                return true;
            }
        });
        no.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    no.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));


                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    no.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));

                }

                return true;
            }
        });*/
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TipsAndOffersActivity.this,Codes1Activity.class));
            }
        });
    }


}
