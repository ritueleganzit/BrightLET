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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.apiparser.CallAPiActivity;
import com.eleganzit.brightlet.apiparser.GetResponse;
import com.eleganzit.brightlet.utils.AppDialogs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class Codes1Activity extends AppCompatActivity {

    String customer_id,customer_api_key,customer_type,mobile_confirmation_code,customer_mobile_number;
    EditText edcode;

    public AppDialogs appDialogs;
    public CallAPiActivity callAPiActivity;

    TextView phone;
    Button submit;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_codes1);

        appDialogs = new AppDialogs(this);
        callAPiActivity=new CallAPiActivity(this);

        customer_id=getIntent().getStringExtra("customer_id");
        customer_api_key=getIntent().getStringExtra("customer_api_key");
        customer_type=getIntent().getStringExtra("customer_type");
        mobile_confirmation_code=getIntent().getStringExtra("mobile_confirmation_code");
        customer_mobile_number=getIntent().getStringExtra("customer_mobile_number");

        phone=findViewById(R.id.phone);
        edcode=findViewById(R.id.edcode);
        submit=findViewById(R.id.submit);
        edcode.setText(mobile_confirmation_code);

        phone.setText(getResources().getString(R.string.enterphone1)+customer_mobile_number+getResources().getString(R.string.enterphone2));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatemobileconfirmation();
            }
        });
    }

    private void updatemobileconfirmation() {


        HashMap<String, String> map = new HashMap<>();
        map.put("request", "update-mobile-confirmation");
        map.put("customer_id", customer_id);
        map.put("customer_api_key", customer_api_key);
        map.put("customer_type", customer_type);
        map.put("mobile_confirmation_code", mobile_confirmation_code);
        callAPiActivity.doRequestCall(this, map, new GetResponse() {
            @Override
            public void onSuccessResult(JSONObject result) throws JSONException {
                Log.e("Response", "" + String.valueOf(result));

                if (result.has("error")) {
                    Toast.makeText(getApplicationContext(), ""+result.getString("error"), Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(Codes1Activity.this, ProfileActivity.class));


                    Toast.makeText(getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailureResult(String message) throws JSONException {
                Log.e("ResponseError", "" + String.valueOf(message));

            }
        });
    }
}
