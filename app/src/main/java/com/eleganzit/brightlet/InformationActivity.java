package com.eleganzit.brightlet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.philliphsu.bottomsheetpickers.BottomSheetPickerDialog;
import com.philliphsu.bottomsheetpickers.date.DatePickerDialog;
import com.philliphsu.bottomsheetpickers.time.BottomSheetTimePickerDialog;

import java.util.Calendar;


public class InformationActivity extends AppCompatActivity implements
        BottomSheetTimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{

    Button yes,no,yes_b,no_b,decrease,increase,decrease_b,increase_b;
    LinearLayout fully,partially,none;
    TextView fully_text,partially_text,none_text,next;
    EditText renewdate1,renewdate2;

    private static final String TAG = "InformationActivity";
    private static final boolean USE_BUILDERS = false;
    int minteger = 0;
    int minteger_b = 0;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_information);

        renewdate1=findViewById(R.id.renew_date_1);
        renewdate2=findViewById(R.id.renew_date_2);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        yes_b=findViewById(R.id.certi_yes);
        no_b=findViewById(R.id.certi_no);
        decrease=findViewById(R.id.decrease);
        increase=findViewById(R.id.increase);
        decrease_b=findViewById(R.id.decrease_b);
        increase_b=findViewById(R.id.increase_b);
        next=findViewById(R.id.next);
        fully=findViewById(R.id.fully);
        partially=findViewById(R.id.partially);
        none=findViewById(R.id.none);
        fully_text=findViewById(R.id.fully_text);
        partially_text=findViewById(R.id.partially_text);
        none_text=findViewById(R.id.none_text);

        renewdate1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    // Show your calender here
                    DialogFragment dialog = createDialog();
                    dialog.show(getSupportFragmentManager(), TAG);
                } else {
                    // Hide your calender here
                }
            }
        });
        renewdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = createDialog();
                dialog.show(getSupportFragmentManager(), TAG);
            }
        });

        renewdate2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    // Show your calender here
                    DialogFragment dialog = createDialog();
                    dialog.show(getSupportFragmentManager(), TAG);
                } else {
                    // Hide your calender here
                }
            }
        });
        renewdate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = createDialog();
                dialog.show(getSupportFragmentManager(), TAG);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(InformationActivity.this,CameraRollActivity.class));

            }
        });

        decrease.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    decrease.setBackground(getResources().getDrawable(R.drawable.button_purple_circle));

                    if(minteger>0)
                    {
                        minteger = minteger - 1;
                    }


                    display(minteger);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    decrease.setBackground(getResources().getDrawable(R.drawable.button_grey_circle));
                }


                return true;
            }
        });
        increase.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    increase.setBackground(getResources().getDrawable(R.drawable.button_purple_circle_plus));

                    minteger = minteger + 1;

                    display(minteger);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    increase.setBackground(getResources().getDrawable(R.drawable.button_grey_circle_plus));
                }


                return true;
            }
        });
        decrease_b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    decrease_b.setBackground(getResources().getDrawable(R.drawable.button_purple_circle));

                    if(minteger_b>0)
                    {
                        minteger_b = minteger_b - 1;
                    }


                    display_b(minteger_b);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    decrease_b.setBackground(getResources().getDrawable(R.drawable.button_grey_circle));
                }


                return true;
            }
        });
        increase_b.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    increase_b.setBackground(getResources().getDrawable(R.drawable.button_purple_circle_plus));

                    minteger_b = minteger_b + 1;

                    display_b(minteger_b);

                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    increase_b.setBackground(getResources().getDrawable(R.drawable.button_grey_circle_plus));
                }


                return true;
            }
        });

        fully.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                fully.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));
                fully_text.setTextColor(Color.parseColor("#ffffff"));
                /*if(v instanceof Button){
                    ((Button)v).setTextColor(Color.parseColor("#ffffff"));
                }*/
                partially.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                partially_text.setTextColor(Color.parseColor("#cbcbcb"));
                none.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                none_text.setTextColor(Color.parseColor("#cbcbcb"));
            }
        });
        partially.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                partially.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));
                partially_text.setTextColor(Color.parseColor("#ffffff"));


                fully.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                fully_text.setTextColor(Color.parseColor("#cbcbcb"));
                none.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                none_text.setTextColor(Color.parseColor("#cbcbcb"));

            }
        });
        none.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                none.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));
                none_text.setTextColor(Color.parseColor("#ffffff"));


                fully.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                fully_text.setTextColor(Color.parseColor("#cbcbcb"));
                partially.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                partially_text.setTextColor(Color.parseColor("#cbcbcb"));

            }
        });

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

        yes_b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                yes_b.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));
                yes_b.setTextColor(Color.parseColor("#ffffff"));
                /*if(v instanceof Button){
                    ((Button)v).setTextColor(Color.parseColor("#ffffff"));
                }*/
                no_b.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                no_b.setTextColor(Color.parseColor("#cbcbcb"));
            }
        });
        no_b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                no_b.setBackground(getResources().getDrawable(R.drawable.button_bg_purple));
                no_b.setTextColor(Color.parseColor("#ffffff"));
                yes_b.setBackground(getResources().getDrawable(R.drawable.button_bg_grey));
                yes_b.setTextColor(Color.parseColor("#cbcbcb"));

            }
        });


    }


    private DialogFragment createDialog() {
        if (USE_BUILDERS) {
            return createDialogWithBuilders();
        } else {
            return createDialogWithSetters();
        }
    }

    private DialogFragment createDialogWithSetters() {
        BottomSheetPickerDialog dialog = null;

        Calendar now = Calendar.getInstance();
        dialog = DatePickerDialog.newInstance(
                InformationActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH));

        DatePickerDialog dateDialog = (DatePickerDialog) dialog;
        dateDialog.setHeaderColor(Color.parseColor("#ffffff"));
        dateDialog.setAccentColor(Color.parseColor("#5a2e87"));
        dateDialog.setMinDate(now);
        Calendar max = Calendar.getInstance();
        max.add(Calendar.YEAR, 10);
        dateDialog.setMaxDate(max);
        dateDialog.setYearRange(1970, 2032);

        return dialog;
    }

    private DialogFragment createDialogWithBuilders() {
        BottomSheetPickerDialog.Builder builder = null;

        Calendar now = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        max.add(Calendar.YEAR, 10);
        builder = new DatePickerDialog.Builder(
                InformationActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH));
        DatePickerDialog.Builder dateDialogBuilder = (DatePickerDialog.Builder) builder;
        dateDialogBuilder.setMaxDate(max)
                .setMinDate(now)
                .setYearRange(1970, 2032);

        return builder.build();
    }


    private void display(int number) {

        TextView displayInteger = (TextView) findViewById(

                R.id.integer_number);

        displayInteger.setText("" + number);

    }


    private void display_b(int number) {

        TextView displayInteger = (TextView) findViewById(

                R.id.integer_number_b);

        displayInteger.setText("" + number);

    }

    @Override
    public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
        Calendar cal = new java.util.GregorianCalendar();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, monthOfYear);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        renewdate1.setText("" + DateFormat.getDateFormat(this).format(cal.getTime()));
    }

    @Override
    public void onTimeSet(ViewGroup viewGroup, int hourOfDay, int minute) {
        Calendar cal = new java.util.GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        cal.set(Calendar.MINUTE, minute);
        renewdate1.setText("" + DateFormat.getTimeFormat(this).format(cal.getTime()));
    }
}
