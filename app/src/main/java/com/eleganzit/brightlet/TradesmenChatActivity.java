package com.eleganzit.brightlet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.eleganzit.brightlet.adapters.MessageListAdapter;
import com.eleganzit.brightlet.model.GetMessages;

import java.util.ArrayList;


public class TradesmenChatActivity extends AppCompatActivity {

    EditText subject,type_message;
    ArrayList<GetMessages> arrayList=new ArrayList<>();
    String[] signin_types = { "6 Download Lane, B4 6AB","7 Download Lane, B4 6AB","8 Download Lane, B4 6AB","9 Download Lane, B4 6AB" };
    String property;
    TableRow camera,photo_gallery,attach_file;
    private MessageListAdapter mMessageAdapter;
    private RecyclerView mMessageRecycler;
    ImageView add;
    RelativeLayout send_bg;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_tradesmen_chat);

        mMessageRecycler = (RecyclerView) findViewById(R.id.message_list);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initbottomsheet();

            }
        });

        GetMessages getMessages=new GetMessages("pic","zahir","hey there hey there hey there hey there","zahir","ahmed","Read 1:09 PM");
        GetMessages getMessages1=new GetMessages("pic","ahmed","hey there hey there hey there hey there hey there","ahmed","zahir","Read 1:09 PM");
        GetMessages getMessages2=new GetMessages("pic","zahir","hey there","zahir","ahmed","Read 1:09 PM");
        GetMessages getMessages3=new GetMessages("pic","ahmed","hey there","ahmed","zahir","Read 1:09 PM");
        GetMessages getMessages4=new GetMessages("pic","zahir","hey there hey there hey there ","zahir","ahmed","Read 1:09 PM");
        GetMessages getMessages5=new GetMessages("pic","ahmed","hey there","ahmed","zahir","Read 1:09 PM");
        GetMessages getMessages6=new GetMessages("pic","zahir","hey there","zahir","ahmed","Read 1:09 PM");
        GetMessages getMessages7=new GetMessages("pic","ahmed","hey there hey there hey there ","ahmed","zahir","Read 1:09 PM");

        arrayList.add(getMessages);
        arrayList.add(getMessages1);
        arrayList.add(getMessages2);
        arrayList.add(getMessages3);
        arrayList.add(getMessages4);
        arrayList.add(getMessages5);
        arrayList.add(getMessages6);
        arrayList.add(getMessages7);
        arrayList.add(getMessages7);
        arrayList.add(getMessages);
        arrayList.add(getMessages1);
        arrayList.add(getMessages2);
        arrayList.add(getMessages3);
        arrayList.add(getMessages4);
        arrayList.add(getMessages5);
        arrayList.add(getMessages6);
        arrayList.add(getMessages4);
        arrayList.add(getMessages5);
        arrayList.add(getMessages6);
        arrayList.add(getMessages7);
        arrayList.add(getMessages7);
        arrayList.add(getMessages);
        arrayList.add(getMessages1);


        mMessageAdapter = new MessageListAdapter(arrayList, this);

        mMessageRecycler.setAdapter(mMessageAdapter);

        subject=findViewById(R.id.subject_chat);
        type_message=findViewById(R.id.type_message);
        send_bg=findViewById(R.id.send_bg);
        send_bg.setClickable(false);
        send_bg.setEnabled(false);
        send_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TradesmenChatActivity.this, "enabled", Toast.LENGTH_SHORT).show();
            }
        });

        subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRadioButtonDialog();
            }
        });
        subject.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    showRadioButtonDialog();

                }
                else
                {

                }
            }
        });
        type_message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                send_bg.setBackgroundResource(R.drawable.send_bg);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count==0)
                {
                    Toast.makeText(TradesmenChatActivity.this, "00", Toast.LENGTH_SHORT).show();
                    send_bg.setBackgroundResource(R.drawable.send_bg);
                    send_bg.setClickable(false);
                    send_bg.setEnabled(false);

                }
                else
                {
                    send_bg.setClickable(true);
                    send_bg.setEnabled(true);
                    send_bg.setBackgroundResource(R.drawable.active_send_bg);

                }
                // send_bg.setBackgroundResource(R.drawable.active_send_bg);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void showRadioButtonDialog() {

        final ListAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, android.R.id.text1, signin_types);

        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                subject.setText(property);
                /*if(property != null && !property .isEmpty())
                {
                    subject.setHint("Property");
                }

                else
                {
                    subject.setHint("Select a Property");
                }
*/
                Toast.makeText(TradesmenChatActivity.this, ""+property, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something
                property=signin_types[which];
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
    public void initbottomsheet()
    {
        LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View sheet=inflater.inflate(R.layout.add_options,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(this);
        dialog.setContentView(sheet);
        dialog.setCancelable(true);
        camera=dialog.findViewById(R.id.camera_b);
        photo_gallery=dialog.findViewById(R.id.photo_gallery_b);
        attach_file=dialog.findViewById(R.id.attach_file_b);
        dialog.show();
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TradesmenChatActivity.this, "camera", Toast.LENGTH_SHORT).show();
            }
        });
        photo_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TradesmenChatActivity.this, "photo gallery", Toast.LENGTH_SHORT).show();
            }
        });
        attach_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TradesmenChatActivity.this, "attach_file", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
