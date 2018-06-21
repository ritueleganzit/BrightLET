package com.eleganzit.brightlet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.model.GetTenantsList;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class SelectTradespersonActivity extends AppCompatActivity {

    Toolbar toolbar, searchtollbar;
    Menu search_menu;
    MenuItem item_search;
    public static FrameLayout layout_MainMenu;
    String mState = "HIDE_MENU"; // setting state

    //private SearchBox search;
    TextView next;
    String radio;
    RecyclerView select_tradesperson;
    ArrayList<GetTenantsList> arrayList=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#5a2e87"));
        setContentView(R.layout.activity_select_tradesperson);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSearchtollbar();

        layout_MainMenu = findViewById( R.id.mainmenu);
        layout_MainMenu.getForeground().setAlpha( 0);
        invalidateOptionsMenu();
        //search = findViewById(R.id.searchbox);
        select_tradesperson=findViewById(R.id.select_tradesperson);
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTradespersonActivity.this,TradesmenChatActivity.class));
            }
        });
        //next=findViewById(R.id.next);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SelectTradespersonActivity.this,LinearLayoutManager.VERTICAL,false);
        select_tradesperson.setLayoutManager(layoutManager);

        GetTenantsList getTenantsList=new GetTenantsList("zahir","ahmedabad");
        GetTenantsList getTenantsList1=new GetTenantsList("zahir","ahmedabad");
        GetTenantsList getTenantsList2=new GetTenantsList("zahir","ahmedabad");
        GetTenantsList getTenantsList3=new GetTenantsList("zahir","ahmedabad");
        GetTenantsList getTenantsList4=new GetTenantsList("zahir","ahmedabad");
        GetTenantsList getTenantsList5=new GetTenantsList("zahir","ahmedabad");
        GetTenantsList getTenantsList6=new GetTenantsList("zahir","ahmedabad");

        arrayList.add(getTenantsList);
        arrayList.add(getTenantsList1);
        arrayList.add(getTenantsList2);
        arrayList.add(getTenantsList3);
        arrayList.add(getTenantsList4);
        arrayList.add(getTenantsList5);
        arrayList.add(getTenantsList6);
        arrayList.add(getTenantsList);
        arrayList.add(getTenantsList1);
        arrayList.add(getTenantsList2);
        arrayList.add(getTenantsList3);
        arrayList.add(getTenantsList4);
        arrayList.add(getTenantsList5);
        arrayList.add(getTenantsList6);
        arrayList.add(getTenantsList);
        arrayList.add(getTenantsList1);
        arrayList.add(getTenantsList2);
        arrayList.add(getTenantsList3);
        arrayList.add(getTenantsList4);
        arrayList.add(getTenantsList5);
        arrayList.add(getTenantsList6);

        select_tradesperson.setAdapter(new RadioButtonAdapter(arrayList,SelectTradespersonActivity.this));
        //search.enableVoiceRecognition(this);
        //search.setHint("Search...");
        //this.setSupportActionBar(toolbar);
       /* toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               // openSearch();
                return true;
            }
        });*/
       /* next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTenantActivity.this,TenantChatActivity.class));
            }
        });*/


    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("message"));
    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            radio = intent.getStringExtra("radiodata");
            Toast.makeText(SelectTradespersonActivity.this," hhhhhhhhhhh" ,Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
       /* if (mState.equalsIgnoreCase("HIDE_MENU"))
        {
                menu.getItem(R.id.action_search).setVisible(false);
        }*/
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.action_search:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    circleReveal(R.id.searchtoolbar, 1, true, true);
                    layout_MainMenu.getForeground().setAlpha( 90);
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#FF3A1F58"));
                }

                else
                    searchtollbar.setVisibility(View.VISIBLE);
                layout_MainMenu.getForeground().setAlpha( 90);


                item_search.expandActionView();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setSearchtollbar()
    {
        searchtollbar = findViewById(R.id.searchtoolbar);
        if (searchtollbar != null) {
            searchtollbar.inflateMenu(R.menu.menu_search);
            search_menu=searchtollbar.getMenu();

            searchtollbar.setNavigationOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        circleReveal(R.id.searchtoolbar, 1, true, false);

                    }
                    else
                        searchtollbar.setVisibility(View.GONE);

                }
            });

            item_search = search_menu.findItem(R.id.action_filter_search);

            MenuItemCompat.setOnActionExpandListener(item_search, new MenuItemCompat.OnActionExpandListener() {
                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    // Do something when collapsed
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        circleReveal(R.id.searchtoolbar,1,true,false);
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(Color.parseColor("#5a2e87"));
                        layout_MainMenu.getForeground().setAlpha(0);
                    }
                    else
                        searchtollbar.setVisibility(View.GONE);
                    layout_MainMenu.getForeground().setAlpha(0);

                    return true;
                }

                @Override
                public boolean onMenuItemActionExpand(MenuItem item) {
                    // Do something when expanded
                    return true;
                }
            });

            initSearchView();


        } else
            Log.d("toolbar", "setSearchtollbar: NULL");
    }
    public void initSearchView()
    {
        final SearchView searchView =
                (SearchView) search_menu.findItem(R.id.action_filter_search).getActionView();

        // Enable/Disable Submit button in the keyboard

        searchView.setSubmitButtonEnabled(false);

        // Change search close button image

        ImageView closeButton = (ImageView) searchView.findViewById(R.id.search_close_btn);
        closeButton.setImageResource(R.drawable.search_dark);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SelectTradespersonActivity.this, "Search tenant!", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    circleReveal(R.id.searchtoolbar,1,true,false);
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#5a2e87"));
                    layout_MainMenu.getForeground().setAlpha(0);
                }
                else
                    searchtollbar.setVisibility(View.GONE);
                layout_MainMenu.getForeground().setAlpha(0);
            }
        });

        // set hint and the text colors

        EditText txtSearch = ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text));
        txtSearch.setHint("Search...");
        txtSearch.setHintTextColor(Color.parseColor("#A0A0A0"));
        txtSearch.setTextColor(Color.parseColor("#000000"));
        txtSearch.setTextSize(15);
        txtSearch.setBackgroundColor(Color.parseColor("#ffffff"));
        txtSearch.setBackground(null);


        // set the cursor

        AutoCompleteTextView searchTextView = (AutoCompleteTextView) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        try {
            Field mCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            mCursorDrawableRes.setAccessible(true);
            mCursorDrawableRes.set(searchTextView, R.drawable.search_cursor); //This sets the cursor resource ID to 0 or @null which will make it visible on white background
        } catch (Exception e) {
            e.printStackTrace();
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                callSearch(query);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                callSearch(newText);
                return true;
            }

            public void callSearch(String query) {
                //Do searching
                Log.i("query", "" + query);

            }

        });

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void circleReveal(int viewID, int posFromRight, boolean containsOverflow, final boolean isShow)
    {
        final View myView = findViewById(viewID);

        int width=myView.getWidth();

        if(posFromRight>0)
            width-=(posFromRight*getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material))-(getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_material)/ 2);
        if(containsOverflow)
            width-=getResources().getDimensionPixelSize(R.dimen.abc_action_button_min_width_overflow_material);

        int cx=width;
        int cy=myView.getHeight()/2;

        Animator anim;
        if(isShow)
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0,(float)width);
        else
            anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, (float)width, 0);

        anim.setDuration((long)220);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if(!isShow)
                {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            }
        });

        // make the view visible and start the animation
        if(isShow)
            myView.setVisibility(View.VISIBLE);

        // start the animation
        anim.start();


    }

    public class RadioButtonAdapter extends RecyclerView.Adapter<RadioButtonAdapter.RadioButtonHolder>
    {

        private int lastCheckedPosition = -1;
        ArrayList<GetTenantsList> arrayList;
        Context context;

        public RadioButtonAdapter(ArrayList<GetTenantsList> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @Override
        public RadioButtonHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v= LayoutInflater.from(context).inflate(R.layout.layout_select_tenant,parent,false);
            RadioButtonHolder radioButtonHolder=new RadioButtonHolder(v);

            return radioButtonHolder;
        }

        @Override
        public void onBindViewHolder(RadioButtonHolder holder, int position) {
            holder.name.setText(arrayList.get(position).getName());
            holder.radioButton.setChecked(position == lastCheckedPosition);
        }


        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class RadioButtonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView name;

            RadioButton radioButton;

            public RadioButtonHolder(View itemView) {
                super(itemView);

                name=itemView.findViewById(R.id.text_name);
                radioButton=itemView.findViewById(R.id.select_radioButton);

                radioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lastCheckedPosition = getAdapterPosition();
                        //because of this blinking problem occurs so
                        //i have a suggestion to add notifyDataSetChanged();
                        //   notifyItemRangeChanged(0, list.length);//blink list problem
                        notifyDataSetChanged();

                    }
                });
            }

            @Override
            public void onClick(View v)
            {

            }
        }
    }
}
