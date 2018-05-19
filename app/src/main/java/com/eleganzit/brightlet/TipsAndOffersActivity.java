package com.eleganzit.brightlet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.eleganzit.brightlet.apiparser.CallAPiActivity;
import com.eleganzit.brightlet.apiparser.GetResponse;
import com.eleganzit.brightlet.utils.AppDialogs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class TipsAndOffersActivity extends AppCompatActivity {



    String customer_type,customer_name,customer_email,customer_password,customer_mobile_number,customer_share_data;
    public AppDialogs appDialogs;
    public CallAPiActivity callAPiActivity;


    Button accept,yes,no;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_tips_and_offers);

        appDialogs = new AppDialogs(this);
        callAPiActivity=new CallAPiActivity(this);

        accept=findViewById(R.id.accept);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);


        customer_type=getIntent().getStringExtra("customer_type");
        customer_name=getIntent().getStringExtra("customer_name");
        customer_email=getIntent().getStringExtra("customer_email");
        customer_password=getIntent().getStringExtra("customer_password");
        customer_mobile_number=getIntent().getStringExtra("customer_mobile_number");



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
                customer_share_data="yes";
                doSignup();
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
                customer_share_data="no";
                doSignup();

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

    }





    private void doSignup() {


        HashMap<String, String> map = new HashMap<>();
        map.put("request", "register");
        map.put("customer_type", customer_type.toLowerCase());
        map.put("customer_name", customer_name);
        map.put("customer_email", customer_email);
        map.put("customer_password", customer_password);
        map.put("customer_mobile_number", customer_mobile_number);
        map.put("user_agent", "android");
        map.put("customer_share_data", customer_share_data);
        callAPiActivity.doRequestCall(this, map, new GetResponse() {
            @Override
            public void onSuccessResult(final JSONObject result) throws JSONException {
                Log.e("Response",""+String.valueOf(result));

                if (result.has("error"))
                {
                    Toast.makeText(getApplicationContext(), ""+result.getString("error"), Toast.LENGTH_SHORT).show();
                }
                else {
                    accept.setEnabled(true);
                    String success=result.getString("success");
                    Toast.makeText(getApplicationContext(), ""+success, Toast.LENGTH_SHORT).show();
                    accept.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            try {
                                Intent intent =new Intent(new Intent(TipsAndOffersActivity.this,Codes1Activity.class));
                                intent.putExtra("customer_id",result.getString("customer_id"));
                                intent.putExtra("customer_api_key",result.getString("customer_api_key"));
                                intent.putExtra("customer_type",result.getString("customer_type"));
                                intent.putExtra("mobile_confirmation_code",result.getString("mobile_confirmation_code"));
                                intent.putExtra("customer_mobile_number",customer_mobile_number);
                                startActivity(intent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }

            @Override
            public void onFailureResult(String message) throws JSONException {
                Log.e("ResponseError",""+String.valueOf(message));

            }
        });

    }


}
