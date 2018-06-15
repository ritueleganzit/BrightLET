package com.eleganzit.brightlet.fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eleganzit.brightlet.LandlordHomeActivity;
import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.SelectTenantActivity;
import com.eleganzit.brightlet.adapters.MyTabAdapter;

import java.lang.reflect.Field;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_messages extends Fragment {


    public Fragment_messages() {
        // Required empty public constructor
        setHasOptionsMenu(true);

    }
    TabLayout tabLayout;
    ViewPager viewPager;
    Menu search_menu;
    MenuItem item_search;
    FrameLayout layout_MainMenu;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_messages, container, false);
        setHasOptionsMenu(true);
        LandlordHomeActivity.welcome.setVisibility(View.GONE);

        LandlordHomeActivity.title.setText("Messages");
        tabLayout=v.findViewById(R.id.messages_tabs);
        viewPager=v.findViewById(R.id.messages_view_pager);
        layout_MainMenu=v.findViewById(R.id.mainmenu);
        layout_MainMenu.getForeground().setAlpha(0);
        LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
        LandlordHomeActivity.topframe.getForeground().setAlpha(0);
        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_tenants_messages(),"TENANTS");
        myTabAdapter.addFragment(new Fragment_tradesmen_messages(),"TRADESMEN");
        viewPager.setAdapter(myTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setSearchtollbar();

        Rect rectangle = new Rect();
        Window window = getActivity().getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        int statusBarHeight = rectangle.top;
        int contentViewTop =
                window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
        int titleBarHeight= contentViewTop - statusBarHeight;

        Log.i("*** Elenasys :: ", "StatusBar Height= " + statusBarHeight + " , TitleBar Height = " + titleBarHeight);

       /* LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        params.setMargins(left, top, right, bottom);
        yourbutton.setLayoutParams(params);*/

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        return v;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if (id == R.id.menu_search) {
            Toast.makeText(getContext(), "Search", Toast.LENGTH_SHORT).show();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                circleReveal(R.id.searchtoolbar, 1, true, true);
                layout_MainMenu.getForeground().setAlpha( 90);
                LandlordHomeActivity.bottomframe.getForeground().setAlpha( 90);
                LandlordHomeActivity.topframe.getForeground().setAlpha(0);
                Window window = getActivity().getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor("#FF3A1F58"));
            }

            else
                LandlordHomeActivity.searchtollbar.setVisibility(View.VISIBLE);
            layout_MainMenu.getForeground().setAlpha( 90);
            LandlordHomeActivity.bottomframe.getForeground().setAlpha( 90);
            LandlordHomeActivity.topframe.getForeground().setAlpha(0);


            item_search.expandActionView();
            return true;
        }

        if (id == R.id.menu_add) {
            getActivity().startActivity(new Intent(getActivity(),SelectTenantActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    public void setSearchtollbar()
    {
        LandlordHomeActivity.searchtollbar = getActivity().findViewById(R.id.searchtoolbar);
        if (LandlordHomeActivity.searchtollbar != null) {
            LandlordHomeActivity.searchtollbar.inflateMenu(R.menu.menu_search);
            search_menu=LandlordHomeActivity.searchtollbar.getMenu();

            LandlordHomeActivity.searchtollbar.setNavigationOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        circleReveal(R.id.searchtoolbar, 1, true, false);

                    }
                    else
                        LandlordHomeActivity.searchtollbar.setVisibility(View.GONE);

                }
            });

            item_search = search_menu.findItem(R.id.action_filter_search);

            MenuItemCompat.setOnActionExpandListener(item_search, new MenuItemCompat.OnActionExpandListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public boolean onMenuItemActionCollapse(MenuItem item) {
                    // Do something when collapsed
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        circleReveal(R.id.searchtoolbar,1,true,false);
                        Window window = getActivity().getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(Color.parseColor("#5a2e87"));
                        layout_MainMenu.getForeground().setAlpha(0);
                        LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                        LandlordHomeActivity.topframe.getForeground().setAlpha(0);
                    }
                    else
                        LandlordHomeActivity.searchtollbar.setVisibility(View.GONE);
                    layout_MainMenu.getForeground().setAlpha(0);
                    LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                    LandlordHomeActivity.topframe.getForeground().setAlpha(0);

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
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Search tenant!", Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    circleReveal(R.id.searchtoolbar,1,true,false);
                    Window window = getActivity().getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#5a2e87"));
                    layout_MainMenu.getForeground().setAlpha(0);
                    LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                    LandlordHomeActivity.topframe.getForeground().setAlpha(0);
                }
                else
                    LandlordHomeActivity.searchtollbar.setVisibility(View.GONE);
                layout_MainMenu.getForeground().setAlpha(0);
                LandlordHomeActivity.bottomframe.getForeground().setAlpha(0);
                LandlordHomeActivity.topframe.getForeground().setAlpha(0);
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
        final View myView = getActivity().findViewById(viewID);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        //int width=myView.getWidth();

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

}
