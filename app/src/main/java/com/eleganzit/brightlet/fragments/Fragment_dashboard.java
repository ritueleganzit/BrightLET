package com.eleganzit.brightlet.fragments;


import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.eleganzit.brightlet.R;
import com.eleganzit.brightlet.adapters.MyTabAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_dashboard extends Fragment {


    public Fragment_dashboard() {
        // Required empty public constructor
    }
    private Boolean isFabOpen = false;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;
    FloatingActionButton fab;
    TabLayout tabLayout;
    ViewPager viewPager;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_dashboard, container, false);

        tabLayout=v.findViewById(R.id.dashboard_tabs);
        viewPager=v.findViewById(R.id.dashboard_view_pager);
        fab=v.findViewById(R.id.fab);
        rotate_forward = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_backward);

        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View v) {
                animateFAB();
                PopupMenu popupMenu=new PopupMenu(getContext(),fab,Gravity.END,0,R.style.MyPopupMenu);
                popupMenu.getMenuInflater().inflate(R.menu.custom_popup_menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
                    @Override
                    public void onDismiss(PopupMenu menu) {
                        fab.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#f39200")}));
                        fab.startAnimation(rotate_backward);
                        isFabOpen = false;

                    }
                });
            }
        });

        MyTabAdapter myTabAdapter=new MyTabAdapter(getChildFragmentManager());
        myTabAdapter.addFragment(new Fragment_reminders(),"REMINDERS");
        myTabAdapter.addFragment(new Fragment_appointment(),"APPOINTMENTS");
        myTabAdapter.addFragment(new Fragment_maintanence(),"MAINTANENCE");
        viewPager.setAdapter(myTabAdapter);
        tabLayout.setupWithViewPager(viewPager);
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
    public void animateFAB(){

        if(isFabOpen){

            fab.startAnimation(rotate_backward);
            fab.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{0}}, new int[]{Color.parseColor("#FFD03131")}));//fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#f39200")));
            /*fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);*/
            isFabOpen = false;
            Log.d("Raj", "close");

        } else {

            fab.startAnimation(rotate_forward);
            fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD03131")));
            //fab.setBackgroundTintMode(PorterDuff.Mode.OVERLAY);

            /*fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);*/
            isFabOpen = true;
            Log.d("Raj","open");

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.custom_popup_menu,menu);
        setMenuBackground();
    }


    protected void setMenuBackground(){
        // Log.d(TAG, "Enterting setMenuBackGround");
        getLayoutInflater().setFactory( new LayoutInflater.Factory() {
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                if ( name.equalsIgnoreCase( "com.android.internal.view.menu.IconMenuItemView" ) ) {
                    try { // Ask our inflater to create the view
                        LayoutInflater f = getLayoutInflater();
                        final View view = f.createView( name, null, attrs );
                        /* The background gets refreshed each time a new item is added the options menu.
                        * So each time Android applies the default background we need to set our own
                        * background. This is done using a thread giving the background change as runnable
                        * object */
                        new Handler().post(new Runnable() {
                            public void run () {
                                // sets the background color
                                view.setBackgroundResource( R.drawable.menu_bg);
                                // sets the text color
                                ((TextView) view).setTextColor(Color.parseColor("#FF5A5A5A"));
                                // sets the text size
                                ((TextView) view).setTextSize(15);
                            }
                        } );
                        return view;
                    }
                    catch ( InflateException e ) {}
                    catch ( ClassNotFoundException e ) {}
                }
                return null;
            }});
    }

}
