package com.eleganzit.brightlet;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;


public class ChatActivity extends AppCompatActivity {

    EditText type_message;
    RelativeLayout send_bg;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_chat);

        type_message=findViewById(R.id.type_message);
        send_bg=findViewById(R.id.send_bg);
        send_bg.setClickable(false);

        type_message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                send_bg.setBackgroundResource(R.drawable.send_bg);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                send_bg.setClickable(true);
               // send_bg.setBackgroundResource(R.drawable.active_send_bg);
            }

            @Override
            public void afterTextChanged(Editable s) {
                send_bg.setBackgroundResource(R.drawable.active_send_bg);

            }
        });
    }
}
