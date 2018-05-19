package com.eleganzit.brightlet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;


public class SignInActivity extends AppCompatActivity {

    String[] signin_types = { "Private Landlord","Tenant","Tradesperson","Lettings Agent" };
    String[] signup_types = { "Private Landlord","Tenant","Lettings Agent" };
    EditText in_who,in_email,in_password,up_who,up_name,up_phone,up_email,up_password;
    LinearLayout signin_layout,signup_layout;
    TextView h_signin,h_signup;
    SharedPreferences sharedPreferences;
    String signdata;
    Button signin,signup;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_sign_in);

        //Create Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, signin_types);
        //Find TextView control
        AutoCompleteTextView e_signin = (AutoCompleteTextView) findViewById(R.id.in_who);
        //Set the number of characters the user must type before the drop down list is shown
        e_signin.setThreshold(-1);
        //Set the adapter
        e_signin.setAdapter(adapter);

        //Create Array Adapter
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, signup_types);
        //Find TextView control
        AutoCompleteTextView e_signup = (AutoCompleteTextView) findViewById(R.id.in_who);
        //Set the number of characters the user must type before the drop down list is shown
        e_signup.setThreshold(-1);
        //Set the adapter
        e_signup.setAdapter(adapter2);


        sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
        signdata=sharedPreferences.getString("sign",null);
        signin_layout=findViewById(R.id.signin_layout);
        signup_layout=findViewById(R.id.signup_layout);
        in_who=findViewById(R.id.in_who);
        in_email=findViewById(R.id.in_email);
        in_password=findViewById(R.id.in_password);
        up_who=findViewById(R.id.up_who);
        up_name=findViewById(R.id.up_name);
        up_phone=findViewById(R.id.up_phone);
        up_email=findViewById(R.id.up_email);
        up_password=findViewById(R.id.up_password);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        h_signin=findViewById(R.id.h_signin);
        h_signup=findViewById(R.id.h_signup);
        Log.d("dataaaaaa",""+signdata);
        if(signdata.equalsIgnoreCase("signin"))
        {
            h_signin.setTextColor(Color.parseColor("#f39200"));
            signin_layout.setVisibility(View.VISIBLE);
            signup_layout.setVisibility(View.GONE);
            signin.setVisibility(View.VISIBLE);
            signup.setVisibility(View.GONE);

        }
        if(signdata.equalsIgnoreCase("signup"))
        {
            h_signup.setTextColor(Color.parseColor("#f39200"));
            signin_layout.setVisibility(View.GONE);
            signup_layout.setVisibility(View.VISIBLE);
            signup.setVisibility(View.VISIBLE);
            signin.setVisibility(View.GONE);
        }
//#f39200
        h_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h_signin.setTextColor(Color.parseColor("#f39200"));
                h_signup.setTextColor(Color.parseColor("#95989a"));
                signin_layout.setVisibility(View.VISIBLE);
                signup_layout.setVisibility(View.GONE);
                signin.setVisibility(View.VISIBLE);
                signup.setVisibility(View.GONE);
            }
        });
        h_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h_signup.setTextColor(Color.parseColor("#f39200"));
                h_signin.setTextColor(Color.parseColor("#95989a"));
                signin_layout.setVisibility(View.GONE);
                signup_layout.setVisibility(View.VISIBLE);
                signup.setVisibility(View.VISIBLE);
                signin.setVisibility(View.GONE);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this,TipsAndOffersActivity.class));
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

}
