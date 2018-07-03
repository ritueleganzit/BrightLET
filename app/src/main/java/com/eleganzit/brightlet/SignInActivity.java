package com.eleganzit.brightlet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.apiparser.CallAPiActivity;
import com.eleganzit.brightlet.apiparser.GetResponse;
import com.eleganzit.brightlet.fonts.TextViewMuseo300;
import com.eleganzit.brightlet.utils.AppDialogs;
import com.github.gfranks.minimal.notification.GFMinimalNotification;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignInActivity extends AppCompatActivity {

    ArrayList<String> customer_types=new ArrayList<>();

    EditText in_who,in_email,in_password,up_who,up_name,up_phone,up_email,up_password;
    LinearLayout signin_layout,signup_layout;
    TextView h_signin,h_signup;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String signdata;
    Button signin,signup;
    public AppDialogs appDialogs;
    public CallAPiActivity callAPiActivity;
    ImageView back;
    RelativeLayout relativeLayout;
    TextViewMuseo300 forgotpassword;

    String customer_type="",customer_email,customer_password;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_sign_in);
        appDialogs = new AppDialogs(this);
        callAPiActivity=new CallAPiActivity(this);
        sharedPreferences=getSharedPreferences("mypref",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        setCustomer_type();
        signdata=sharedPreferences.getString("sign",null);
        signin_layout=findViewById(R.id.signin_layout);
        back=findViewById(R.id.back);
        signup_layout=findViewById(R.id.signup_layout);
        in_who=findViewById(R.id.in_who);
        in_email=findViewById(R.id.in_email);
        in_password=findViewById(R.id.in_password);
        forgotpassword=findViewById(R.id.forgotpassword);
        up_who=findViewById(R.id.up_who);
        up_name=findViewById(R.id.up_name);
        up_phone=findViewById(R.id.up_phone);
        up_email=findViewById(R.id.up_email);
        up_password=findViewById(R.id.up_password);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        h_signin=findViewById(R.id.h_signin);
        h_signup=findViewById(R.id.h_signup);
        relativeLayout=findViewById(R.id.custom_toast_layout);

        in_who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRadioButtonDialog();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        up_who.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRadioDialog();
            }
        });




        /*HashMap<String, String> map = new HashMap<>();
        map.put("request", "list-property-types");
        map.put("customer_id", "onqfqQ");
        map.put("customer_api_key","9e52c2ea3e73465e");


        callAPiActivity.doRequestCall(SignInActivity.this, map, new GetResponse() {
            @Override
            public void onSuccessResult(JSONObject result) throws JSONException {
                Log.e("Response",""+String.valueOf(result));
                Iterator<String> keys = result.keys();
                while( keys.hasNext() )
                {
                    String key = keys.next();

                    String value = result.getString(key);
                    Log.v("key" ,""+value);
                    *//*Iterator<String> innerKeys = result.keys();
                    while( innerKeys.hasNext() )
                    {
                        String innerKkey = keys.next();
                        String value = result.getString(innerKkey);
                        Log.v("key = "+key, "value = "+value);
                    }*//*
                }

            }

            @Override
            public void onFailureResult(String message) throws JSONException {

            }
        });*/
        if(signdata.equalsIgnoreCase("signin"))
        {
            h_signin.setTextColor(Color.parseColor("#f39200"));
            signin_layout.setVisibility(View.VISIBLE);
            signup_layout.setVisibility(View.GONE);
            signin.setVisibility(View.VISIBLE);
            signup.setVisibility(View.GONE);

            in_email.setText("");
            in_password.setText("");
            in_who.setText("");
            up_name.setText("");
            up_password.setText("");
            up_who.setText("");
            up_email.setText("");
            up_phone.setText("");

        }
        if(signdata.equalsIgnoreCase("signup"))
        {
            h_signup.setTextColor(Color.parseColor("#f39200"));
            signin_layout.setVisibility(View.GONE);
            signup_layout.setVisibility(View.VISIBLE);
            signup.setVisibility(View.VISIBLE);
            signin.setVisibility(View.GONE);
            up_name.setText("");
            up_password.setText("");
            up_who.setText("");
            up_email.setText("");
            up_phone.setText("");
        }
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


        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignInActivity.this,ForgotPasswordActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValidSignUp()) {
                    // doLogin();

                    Intent intent=new Intent(SignInActivity.this,TipsAndOffersActivity.class);
                    /*intent.putExtra("customer_type",customer_type.replace(' ', '-').toLowerCase());
                    intent.putExtra("customer_name",up_name.getText().toString());
                    intent.putExtra("customer_email",up_email.getText().toString());
                    intent.putExtra("customer_password",up_password.getText().toString());
                    intent.putExtra("customer_mobile_number",up_phone.getText().toString());
*/
                    editor.putString("customer_type",customer_type.replace(' ', '-').toLowerCase());
                    editor.putString("customer_name",up_name.getText().toString());
                    editor.putString("customer_email",up_email.getText().toString());
                    editor.putString("customer_password",up_password.getText().toString());
                    editor.putString("customer_mobile_number",up_phone.getText().toString());

                    editor.commit();


                    startActivity(intent);


                }




            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValid()) {
                    doLogin();

                }
            }
        });



    }

    private void doLogin() {

        HashMap<String, String> map = new HashMap<>();
        map.put("request", "login");

        map.put("customer_type", customer_type.replace(' ', '-').toLowerCase());


        map.put("customer_email", in_email.getText().toString());
        map.put("customer_password", in_password.getText().toString());
        callAPiActivity.doRequestCall(this, map, new GetResponse() {
            @Override
            public void onSuccessResult(JSONObject result) throws JSONException {
                Log.e("Response",""+String.valueOf(result));

                if (result.has("error"))
                {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
                else {

                    editor.putString("customer_id",result.getString("customer_id"));
                    editor.putString("customer_name",result.getString("customer_name"));
                    editor.putString("customer_email",result.getString("customer_email"));
                    editor.putString("customer_type",result.getString("customer_type"));
                    editor.putString("customer_status",result.getString("customer_status"));
                    editor.putString("parent_customer_id",result.getString("parent_customer_id"));
                    editor.putString("agreed_terms_datetime",result.getString("agreed_terms_datetime"));
                    editor.putString("customer_share_data_datetime",result.getString("customer_share_data_datetime"));
                    editor.putString("customer_api_key",result.getString("customer_api_key"));
                    editor.putString("is_valid_mobile_number",result.getString("is_valid_mobile_number"));
                    editor.putString("mobile_confirmation_code",result.getString("mobile_confirmation_code"));
                    editor.putString("customer_profile_image",result.getString("customer_profile_image"));
                    editor.putString("agreed_terms",result.getString("agreed_terms"));
                    editor.putString("agreed_share",result.getString("agreed_share"));
                    editor.putString("customer_initials",result.getString("customer_initials"));
                    editor.putString("action",result.getString("action"));
                    editor.commit();

                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignInActivity.this,LandlordHomeActivity.class));
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                }
            }

            @Override
            public void onFailureResult(String message) throws JSONException {
                Log.e("ResponseError",""+String.valueOf(message));

            }
        });

    }





    private void showRadioButtonDialog() {

        final ListAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, android.R.id.text1, customer_types);

        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if(customer_type != null && !customer_type.isEmpty()) {
                    in_who.setText(customer_type);
                }

                //Toast.makeText(SignInActivity.this, ""+customer_type, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something
                customer_type=customer_types.get(which);
            }
        });

        // Show the AlertDialog
        final AlertDialog dialog = builder.show();

        // Change the title divider
        final Resources res = getResources();
        final int titleDividerId = res.getIdentifier("titleDivider", "id", "android");
        final View titleDivider = dialog.findViewById(titleDividerId);
        // titleDivider.setBackgroundColor(res.getColor(android.R.color.holo_orange_dark));
    }


    private void showRadioDialog() {

        final ListAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, android.R.id.text1, customer_types);

        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                up_who.setText(customer_type);
                // Toast.makeText(SignInActivity.this, ""+customer_type, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something
                customer_type=customer_types.get(which);
            }
        });

        // Show the AlertDialog
        final AlertDialog dialog = builder.show();

        // Change the title divider
        final Resources res = getResources();
        final int titleDividerId = res.getIdentifier("titleDivider", "id", "android");
        final View titleDivider = dialog.findViewById(titleDividerId);
        // titleDivider.setBackgroundColor(res.getColor(android.R.color.holo_orange_dark));
    }


    public boolean isValid() {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(in_email.getText().toString());
        if (in_who.getText().toString().equals("")) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please Select Type", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            return false;
        }
        if (in_email.getText().toString().equals("")) {
            //in_email.setError("Please enter valid id");
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please enter valid id", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            in_email.requestFocus();
            return false;
        }
        else if (!matcher.matches()) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please type valid email", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();

            in_email.requestFocus();
            return false;
        }  else if (in_password.getText().toString().equals("")) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please enter password", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            in_password.requestFocus();
            return false;
        } else if (in_password.getText().toString().length() < 8) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Password must be minimum 8 characters", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            in_password.requestFocus();
            return false;
        }

        return true;
    }




    public boolean isValidSignUp() {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(up_email.getText().toString());
        if (up_who.getText().toString().equals("")) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please Select Type", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            return false;
        }

        else if (up_name.getText().toString().equals("")) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please enter name", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            up_name.requestFocus();
            return false;
        }
        else if (up_phone.getText().toString().equals("")) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please enter phone number", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            up_phone.requestFocus();
            return false;
        }
        else if (up_phone.getText().toString().length() < 11) {

            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please enter valid phone", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            up_phone.requestFocus();

            return false;
        }
        else if (up_email.getText().toString().equals("")) {

            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please enter valid id", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            up_email.requestFocus();
            return false;
        }
        else if (!matcher.matches()) {

            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please type valid email", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            up_email.requestFocus();
            return false;
        }  else if (up_password.getText().toString().equals("")) {

            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Please enter password", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            up_password.requestFocus();
            return false;
        } else if (up_password.getText().toString().length() < 8) {
            GFMinimalNotification mCurrentNotification = GFMinimalNotification.make(relativeLayout, "Password must be minimum 8 characters", GFMinimalNotification.LENGTH_LONG, GFMinimalNotification.TYPE_ERROR);
            mCurrentNotification.setDirection(GFMinimalNotification.DIRECTION_TOP);
            mCurrentNotification.setHelperImage(R.drawable.group_40);
            mCurrentNotification.show();
            up_password.requestFocus();
            return false;
        }

        return true;
    }


    public void setCustomer_type(){
        HashMap<String, String> map = new HashMap<>();
        map.put("request", "list-customer-types");

        callAPiActivity.doRequestCall(SignInActivity.this, map, new GetResponse() {
            @Override
            public void onSuccessResult(JSONObject result) throws JSONException {
                Log.e("Response",""+String.valueOf(result));
                Iterator<String> keys = result.keys();
                while( keys.hasNext() )
                {
                    String key = keys.next();

                    String value = result.getString(key);
                    Log.v("key" ,""+value);
                    customer_types.add(value);
                    /*Iterator<String> innerKeys = result.keys();
                    while( innerKeys.hasNext() )
                    {
                        String innerKkey = keys.next();
                        String value = result.getString(innerKkey);
                        Log.v("key = "+key, "value = "+value);
                    }*/
                }

            }

            @Override
            public void onFailureResult(String message) throws JSONException {

            }
        });

    }
}